package com.github.mmo.game.domain.player;
public class PlayerLevelInfo
{
	private int[] stats = new int[Framework.Constants.stats.max.getValue()];
	public final int[] getStats()
	{
		return stats;
	}
	public final void setStats(int[] value)
	{
		stats = value;
	}
}
