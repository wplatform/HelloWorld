package com.github.mmo.game.pools;

public class PoolObject
{
	public long UUID;
	public float chance;

	public PoolObject(long guid, float chance)
	{
		UUID = guid;
		chance = Math.abs(chance);
	}
}
