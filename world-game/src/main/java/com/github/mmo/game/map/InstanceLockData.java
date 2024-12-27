package com.github.mmo.game.map;
public class InstanceLockData
{
	private String data;
	public final String getData()
	{
		return data;
	}
	public final void setData(String value)
	{
		data = value;
	}
	private int completedEncountersMask;
	public final int getCompletedEncountersMask()
	{
		return completedEncountersMask;
	}
	public final void setCompletedEncountersMask(int value)
	{
		completedEncountersMask = value;
	}
	private int entranceWorldSafeLocId;
	public final int getEntranceWorldSafeLocId()
	{
		return entranceWorldSafeLocId;
	}
	public final void setEntranceWorldSafeLocId(int value)
	{
		entranceWorldSafeLocId = value;
	}
}
