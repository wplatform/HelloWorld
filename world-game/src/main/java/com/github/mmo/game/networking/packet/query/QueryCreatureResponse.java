package com.github.mmo.game.networking.packet.query;


public class QueryCreatureResponse extends ServerPacket
{
	public boolean allow;
	public Creaturestats stats;
	public int creatureID;
	public QueryCreatureResponse()
	{
		super(ServerOpcode.QueryCreatureResponse, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeInt32(creatureID);
		this.writeBit(allow);
		this.flushBits();

		if (allow)
		{
			this.writeBits(stats.title.isEmpty() ? 0 : stats.title.getBytes().length + 1, 11);
			this.writeBits(stats.titleAlt.isEmpty() ? 0 : stats.titleAlt.getBytes().length + 1, 11);
			this.writeBits(stats.cursorName.isEmpty() ? 0 : stats.cursorName.getBytes().length + 1, 6);
			this.writeBit(stats.leader);

			for (var i = 0; i < SharedConst.MaxCreatureNames; ++i)
			{
				this.writeBits(stats.name.charAt(i).getBytes().length + 1, 11);
				this.writeBits(stats.nameAlt.get(i).getBytes().length + 1, 11);
			}

			for (var i = 0; i < SharedConst.MaxCreatureNames; ++i)
			{
				if (!tangible.StringHelper.isNullOrEmpty(stats.name.charAt(i)))
				{
					this.writeCString(stats.name.charAt(i));
				}

				if (!tangible.StringHelper.isNullOrEmpty(stats.nameAlt.get(i)))
				{
					this.writeCString(stats.nameAlt.get(i));
				}
			}

			for (var i = 0; i < 2; ++i)
			{
				this.writeInt32(stats.Flags[i]);
			}

			this.writeInt32(stats.creatureType);
			this.writeInt32(stats.creatureFamily);
			this.writeInt32(stats.classification);

			for (var i = 0; i < SharedConst.MaxCreatureKillCredit; ++i)
			{
				this.writeInt32(stats.ProxyCreatureID[i]);
			}

			this.writeInt32(stats.display.creatureDisplay.size());
			this.writeFloat(stats.display.totalProbability);

			for (var display : stats.display.creatureDisplay)
			{
				this.writeInt32(display.creatureDisplayID);
				this.writeFloat(display.scale);
				this.writeFloat(display.probability);
			}

			this.writeFloat(stats.hpMulti);
			this.writeFloat(stats.energyMulti);

			this.writeInt32(stats.questItems.size());
			this.writeInt32(stats.creatureMovementInfoID);
			this.writeInt32(stats.healthScalingExpansion);
			this.writeInt32(stats.requiredExpansion);
			this.writeInt32(stats.vignetteID);
			this.writeInt32(stats.class);
			this.writeInt32(stats.creatureDifficultyID);
			this.writeInt32(stats.widgetSetID);
			this.writeInt32(stats.widgetSetUnitConditionID);

			if (!stats.title.isEmpty())
			{
				this.writeCString(stats.title);
			}

			if (!stats.titleAlt.isEmpty())
			{
				this.writeCString(stats.titleAlt);
			}

			if (!stats.cursorName.isEmpty())
			{
				this.writeCString(stats.cursorName);
			}

			for (var questItem : stats.questItems)
			{
				this.writeInt32(questItem);
			}
		}
	}
}
