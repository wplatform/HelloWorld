package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.networking.*;

class ContentTuningParams
{
	public enum ContentTuningType
	{
		CreatureToPlayerDamage(1),
		PlayerToCreatureDamage(2),
		CreatureToCreatureDamage(4),
		PlayerToSandboxScaling(7), // NYI
		PlayerToPlayerExpectedStat(8);

		public static final int SIZE = Integer.SIZE;

		private int intValue;
		private static java.util.HashMap<Integer, ContentTuningType> mappings;
		private static java.util.HashMap<Integer, ContentTuningType> getMappings()
		{
			if (mappings == null)
			{
				synchronized (ContentTuningType.class)
				{
					if (mappings == null)
					{
						mappings = new java.util.HashMap<Integer, ContentTuningType>();
					}
				}
			}
			return mappings;
		}

		private ContentTuningType(int value)
		{
			intValue = value;
			getMappings().put(value, this);
		}

		public int getValue()
		{
			return intValue;
		}

		public static ContentTuningType forValue(int value)
		{
			return getMappings().get(value);
		}
	}

	public enum ContentTuningFlags
	{
		NoLevelScaling(0x1),
		NoItemLevelScaling(0x2);

		public static final int SIZE = Integer.SIZE;

		private int intValue;
		private static java.util.HashMap<Integer, ContentTuningFlags> mappings;
		private static java.util.HashMap<Integer, ContentTuningFlags> getMappings()
		{
			if (mappings == null)
			{
				synchronized (ContentTuningFlags.class)
				{
					if (mappings == null)
					{
						mappings = new java.util.HashMap<Integer, ContentTuningFlags>();
					}
				}
			}
			return mappings;
		}

		private ContentTuningFlags(int value)
		{
			intValue = value;
			getMappings().put(value, this);
		}

		public int getValue()
		{
			return intValue;
		}

		public static ContentTuningFlags forValue(int value)
		{
			return getMappings().get(value);
		}
	}

	public ContenttuningType tuningType = ContentTuningType.values()[0];
	public short playerLevelDelta;
	public float playerItemLevel;
	public float targetItemLevel;
	public short scalingHealthItemLevelCurveID;
	public byte targetLevel;
	public byte expansion;
	public byte targetScalingLevelDelta;
	public ContentTuningflags flags = ContentTuningFlags.forValue(ContentTuningFlags.NoLevelScaling.getValue() | ContentTuningFlags.NoItemLevelScaling.getValue());
	public int playerContentTuningID;
	public int targetContentTuningID;
	public int unused927;

	public final boolean generateDataForUnits(Unit attacker, Unit target)
	{
		var playerAttacker = attacker.toPlayer();
		var creatureAttacker = attacker.toCreature();

		if (playerAttacker)
		{
			var playerTarget = target.toPlayer();
			var creatureTarget = target.toCreature();

			if (playerTarget)
			{
				return generateDataPlayerToPlayer(playerAttacker, playerTarget);
			}
			else if (creatureTarget)
			{
				if (creatureTarget.getHasScalableLevels())
				{
					return generateDataPlayerToCreature(playerAttacker, creatureTarget);
				}
			}
		}
		else if (creatureAttacker)
		{
			var playerTarget = target.toPlayer();
			var creatureTarget = target.toCreature();

			if (playerTarget)
			{
				if (creatureAttacker.getHasScalableLevels())
				{
					return generateDataCreatureToPlayer(creatureAttacker, playerTarget);
				}
			}
			else if (creatureTarget)
			{
				if (creatureAttacker.getHasScalableLevels() || creatureTarget.getHasScalableLevels())
				{
					return generateDataCreatureToCreature(creatureAttacker, creatureTarget);
				}
			}
		}

		return false;
	}

	public final void write(WorldPacket data)
	{
		data.writeFloat(playerItemLevel);
		data.writeFloat(targetItemLevel);
		data.writeInt16(playerLevelDelta);
		data.writeInt16(scalingHealthItemLevelCurveID);
		data.writeInt8(targetLevel);
		data.writeInt8(expansion);
		data.writeInt8(targetScalingLevelDelta);
		data.writeInt32((int)flags.getValue());
		data.writeInt32(playerContentTuningID);
		data.writeInt32(targetContentTuningID);
		data.writeInt32(unused927);
		data.writeBits(tuningType, 4);
		data.flushBits();
	}

	private boolean generateDataPlayerToPlayer(Player attacker, Player target)
	{
		return false;
	}

	private boolean generateDataCreatureToPlayer(Creature attacker, Player target)
	{
		var creatureTemplate = attacker.getTemplate();
		var creatureScaling = creatureTemplate.getLevelScaling(attacker.getMap().getDifficultyID());

		tuningType = ContentTuningType.CreatureToPlayerDamage;
		playerLevelDelta = (short)target.getActivePlayerData().scalingPlayerLevelDelta;
		playerItemLevel = (short)target.getAverageItemLevel();
		scalingHealthItemLevelCurveID = (short)target.getUnitData().scalingHealthItemLevelCurveID;
		targetLevel = (byte)target.getLevel();
		expansion = (byte)creatureTemplate.healthScalingExpansion;
		targetScalingLevelDelta = (byte)attacker.getUnitData().scalingLevelDelta;
		targetContentTuningID = creatureScaling.contentTuningId;

		return true;
	}

	private boolean generateDataPlayerToCreature(Player attacker, Creature target)
	{
		var creatureTemplate = target.getTemplate();
		var creatureScaling = creatureTemplate.getLevelScaling(target.getMap().getDifficultyID());

		tuningType = ContentTuningType.PlayerToCreatureDamage;
		playerLevelDelta = (short)attacker.getActivePlayerData().scalingPlayerLevelDelta;
		playerItemLevel = (short)attacker.getAverageItemLevel();
		scalingHealthItemLevelCurveID = (short)target.getUnitData().scalingHealthItemLevelCurveID;
		targetLevel = (byte)target.getLevel();
		expansion = (byte)creatureTemplate.healthScalingExpansion;
		targetScalingLevelDelta = (byte)target.getUnitData().scalingLevelDelta;
		targetContentTuningID = creatureScaling.contentTuningId;

		return true;
	}

	private boolean generateDataCreatureToCreature(Creature attacker, Creature target)
	{
		var accessor = target.getHasScalableLevels() ? target : attacker;
		var creatureTemplate = accessor.getTemplate();
		var creatureScaling = creatureTemplate.getLevelScaling(accessor.getMap().getDifficultyID());

		tuningType = ContentTuningType.CreatureToCreatureDamage;
		playerLevelDelta = 0;
		playerItemLevel = 0;
		targetLevel = (byte)target.getLevel();
		expansion = (byte)creatureTemplate.healthScalingExpansion;
		targetScalingLevelDelta = (byte)accessor.getUnitData().scalingLevelDelta;
		targetContentTuningID = creatureScaling.contentTuningId;

		return true;
	}
}
