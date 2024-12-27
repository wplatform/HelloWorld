package com.github.mmo.game.spell;
public enum AuraObjectType
{
	unit,
	DynObj;

	public static final int SIZE = Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static AuraObjectType forValue(int value)
	{
		return values()[value];
	}
}
