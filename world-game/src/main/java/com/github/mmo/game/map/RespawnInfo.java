package com.github.mmo.game.map;



public class RespawnInfo
{
	private SpawnobjectType objectType = SpawnObjectType.values()[0];
	public final SpawnObjectType getObjectType()
	{
		return objectType;
	}
	public final void setObjectType(SpawnObjectType value)
	{
		objectType = value;
	}
	private long spawnId;
	public final long getSpawnId()
	{
		return spawnId;
	}
	public final void setSpawnId(long value)
	{
		spawnId = value;
	}
	private int entry;
	public final int getEntry()
	{
		return entry;
	}
	public final void setEntry(int value)
	{
		entry = value;
	}
	private long respawnTime;
	public final long getRespawnTime()
	{
		return respawnTime;
	}
	public final void setRespawnTime(long value)
	{
		respawnTime = value;
	}
	private int gridId;
	public final int getGridId()
	{
		return gridId;
	}
	public final void setGridId(int value)
	{
		gridId = value;
	}

	public RespawnInfo()
	{
	}

	public RespawnInfo(RespawnInfo info)
	{
		setObjectType(info.getObjectType());
		setSpawnId(info.getSpawnId());
		setEntry(info.getEntry());
		setRespawnTime(info.getRespawnTime());
		setGridId(info.getGridId());
	}
}
