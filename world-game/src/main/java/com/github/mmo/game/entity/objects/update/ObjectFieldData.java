package com.github.mmo.game.entity;


import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.*;

public class ObjectFieldData extends BaseUpdateData<WorldObject>
{
	public UpdateField<Integer> entryId = new UpdateField<Integer>(0, 1);
	public UpdateField<Integer> dynamicFlags = new UpdateField<Integer>(0, 2);
	public UpdateField<Float> scale = new UpdateField<Float>(0, 3);

	public objectFieldData()
	{
		super(0, TypeId.object, 4);
	}

	public final void writeCreate(WorldPacket data, UpdateFieldFlag fieldVisibilityFlags, WorldObject owner, Player receiver)
	{
		data.writeInt32(getViewerDependentEntryId(this, owner, receiver));
		data.writeInt32(getViewerDependentDynamicFlags(this, owner, receiver));
		data.writeFloat(scale);
	}

	public final void writeUpdate(WorldPacket data, UpdateFieldFlag fieldVisibilityFlags, WorldObject owner, Player receiver)
	{
		writeUpdate(data, getChangesMask(), false, owner, receiver);
	}

	public final void writeUpdate(WorldPacket data, UpdateMask changesMask, boolean ignoreNestedChangesMask, WorldObject owner, Player receiver)
	{
		data.writeBits(changesMask.getBlock(0), 4);

		data.flushBits();

		if (changesMask.get(0))
		{
			if (changesMask.get(1))
			{
				data.writeInt32(getViewerDependentEntryId(this, owner, receiver));
			}

			if (changesMask.get(2))
			{
				data.writeInt32(getViewerDependentDynamicFlags(this, owner, receiver));
			}

			if (changesMask.get(3))
			{
				data.writeFloat(scale);
			}
		}
	}

	@Override
	public void clearChangesMask()
	{
		clearChangesMask(entryId);
		clearChangesMask(dynamicFlags);
		clearChangesMask(scale);
		getChangesMask().resetAll();
	}

	private int getViewerDependentEntryId(ObjectFieldData objectData, WorldObject obj, Player receiver)
	{
		int entryId = objectData.entryId;
		var unit = obj.toUnit();

		if (unit != null)
		{
			var summon = unit.toTempSummon();

			if (summon != null)
			{
				if (Objects.equals(summon.getSummonerGUID(), receiver.getGUID()) && summon.getCreatureIdVisibleToSummoner() != null)
				{
					entryId = summon.getCreatureIdVisibleToSummoner().intValue();
				}
			}
		}

		return entryId;
	}

	private int getViewerDependentDynamicFlags(ObjectFieldData objectData, WorldObject obj, Player receiver)
	{
		int unitDynFlags = objectData.dynamicFlags;

		var unit = obj.toUnit();

		if (unit != null)
		{
			var creature = obj.toCreature();

			if (creature != null)
			{
				if ((unitDynFlags & (int)UnitDynFlags.Tapped.getValue()) != 0 && !creature.isTappedBy(receiver))
				{
					unitDynFlags &= ~(int)UnitDynFlags.Tapped.getValue();
				}

				if ((unitDynFlags & (int)UnitDynFlags.Lootable.getValue()) != 0 && !receiver.isAllowedToLoot(creature))
				{
					unitDynFlags &= ~(int)UnitDynFlags.Lootable.getValue();
				}

				if ((unitDynFlags & (int)UnitDynFlags.CanSkin.getValue()) != 0 && creature.isSkinnedBy(receiver))
				{
					unitDynFlags &= ~(int)UnitDynFlags.CanSkin.getValue();
				}
			}

			// unit UNIT_DYNFLAG_TRACK_UNIT should only be sent to caster of SPELL_AURA_MOD_STALKED auras
			if (unitDynFlags.HasAnyFlag((int)UnitDynFlags.TrackUnit.getValue()))
			{
				if (!unit.hasAuraTypeWithCaster(AuraType.ModStalked, receiver.getGUID()))
				{
					unitDynFlags &= ~(int)UnitDynFlags.TrackUnit.getValue();
				}
			}
		}
		else
		{
			var gameObject = obj.toGameObject();

			if (gameObject != null)
			{
				GameObjectDynamicLowFlags dynFlags = GameObjectDynamicLowFlags.forValue(0);
				short pathProgress = (short)0xFFFF;

				switch (gameObject.getGoType())
				{
					case QuestGiver:
						if (gameObject.activateToQuest(receiver))
						{
							dynFlags = GameObjectDynamicLowFlags.forValue(dynFlags.getValue() | GameObjectDynamicLowFlags.Activate.getValue());
						}

						break;
					case Chest:
						if (gameObject.activateToQuest(receiver))
						{
							dynFlags = GameObjectDynamicLowFlags.forValue(dynFlags.getValue() | GameObjectDynamicLowFlags.forValue(GameObjectDynamicLowFlags.Activate.getValue() | GameObjectDynamicLowFlags.Sparkle.getValue().getValue() | GameObjectDynamicLowFlags.Highlight.getValue().getValue()).getValue());
						}
						else if (receiver.isGameMaster())
						{
							dynFlags = GameObjectDynamicLowFlags.forValue(dynFlags.getValue() | GameObjectDynamicLowFlags.Activate.getValue());
						}

						break;
					case Goober:
						if (gameObject.activateToQuest(receiver))
						{
							dynFlags = GameObjectDynamicLowFlags.forValue(dynFlags.getValue() | GameObjectDynamicLowFlags.Highlight.getValue());

							if (gameObject.getGoStateFor(receiver.getGUID()) != GOState.active)
							{
								dynFlags = GameObjectDynamicLowFlags.forValue(dynFlags.getValue() | GameObjectDynamicLowFlags.Activate.getValue());
							}
						}
						else if (receiver.isGameMaster())
						{
							dynFlags = GameObjectDynamicLowFlags.forValue(dynFlags.getValue() | GameObjectDynamicLowFlags.Activate.getValue());
						}

						break;
					case Generic:
						if (gameObject.activateToQuest(receiver))
						{
							dynFlags = GameObjectDynamicLowFlags.forValue(dynFlags.getValue() | GameObjectDynamicLowFlags.forValue(GameObjectDynamicLowFlags.Sparkle.getValue() | GameObjectDynamicLowFlags.Highlight.getValue()).getValue());
						}

						break;
					case Transport:
					case MapObjTransport:
					{
						dynFlags = GameObjectDynamicLowFlags.forValue((short)((int)unitDynFlags & 0xFFFF));
						pathProgress = (short)((int)unitDynFlags >> 16);

						break;
					}
					case CapturePoint:
						if (!gameObject.canInteractWithCapturePoint(receiver))
						{
							dynFlags = GameObjectDynamicLowFlags.forValue(dynFlags.getValue() | GameObjectDynamicLowFlags.NoInterract.getValue());
						}
						else
						{
							dynFlags = GameObjectDynamicLowFlags.forValue(dynFlags.getValue() & ~GameObjectDynamicLowFlags.NoInterract.getValue());
						}

						break;
					case GatheringNode:
						if (gameObject.activateToQuest(receiver))
						{
							dynFlags = GameObjectDynamicLowFlags.forValue(dynFlags.getValue() | GameObjectDynamicLowFlags.forValue(GameObjectDynamicLowFlags.Activate.getValue() | GameObjectDynamicLowFlags.Sparkle.getValue().getValue() | GameObjectDynamicLowFlags.Highlight.getValue().getValue()).getValue());
						}

						if (gameObject.getGoStateFor(receiver.getGUID()) == GOState.active)
						{
							dynFlags = GameObjectDynamicLowFlags.forValue(dynFlags.getValue() | GameObjectDynamicLowFlags.Depleted.getValue());
						}

						break;
					default:
						break;
				}

				if (!gameObject.meetsInteractCondition(receiver))
				{
					dynFlags = GameObjectDynamicLowFlags.forValue(dynFlags.getValue() | GameObjectDynamicLowFlags.NoInterract.getValue());
				}

				unitDynFlags = ((int)pathProgress << 16) | (int)dynFlags.getValue();
			}
		}

		return unitDynFlags;
	}
}
