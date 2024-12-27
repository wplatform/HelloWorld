package com.github.mmo.game.map;
public class DungeonEncounterData
{
	private int bossId;
	public final int getBossId()
	{
		return bossId;
	}
	public final void setBossId(int value)
	{
		bossId = value;
	}
	private int[] dungeonEncounterId = new int[4];
	public final int[] getDungeonEncounterId()
	{
		return dungeonEncounterId;
	}
	public final void setDungeonEncounterId(int[] value)
	{
		dungeonEncounterId = value;
	}

	public DungeonEncounterData(int bossId, Integer... dungeonEncounterIds)
	{
		setBossId(bossId);
		setDungeonEncounterId(dungeonEncounterIds);
	}
}
