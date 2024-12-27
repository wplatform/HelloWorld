package com.github.mmo.game.map;
public class MinionData
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

	public MinionData(int entry, int _bossid)
	{
		setEntry(entry);
		setBossId(_bossid);
	}
}
