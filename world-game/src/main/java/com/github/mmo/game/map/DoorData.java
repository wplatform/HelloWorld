package com.github.mmo.game.map;



public class DoorData
{
	private int entry;
	public final int getEntry()
	{
		return entry;
	}
	public final void setEntry(int value)
	{
		entry = value;
	}
	private int bossId;
	public final int getBossId()
	{
		return bossId;
	}
	public final void setBossId(int value)
	{
		bossId = value;
	}
	private Doortype type = DoorType.values()[0];
	public final DoorType getType()
	{
		return type;
	}
	public final void setType(DoorType value)
	{
		type = value;
	}

	public DoorData(int entry, int bossid, DoorType doorType)
	{
		setEntry(entry);
		setBossId(bossid);
		setType(doorType);
	}
}
