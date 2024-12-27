package com.github.mmo.game.map;
public class BossBoundaryEntry
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
	private Areaboundary boundary;
	public final AreaBoundary getBoundary()
	{
		return boundary;
	}
	public final void setBoundary(AreaBoundary value)
	{
		boundary = value;
	}

	public BossBoundaryEntry(int bossId, AreaBoundary boundary)
	{
		setBossId(bossId);
		setBoundary(boundary);
	}
}
