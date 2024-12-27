package com.github.mmo.game.ai;

public enum AITarget
{
	Self,
	victim,
	Enemy,
	Ally,
	Buff,
	Debuff;

	public static final int SIZE = Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static AITarget forValue(int value)
	{
		return values()[value];
	}
}
