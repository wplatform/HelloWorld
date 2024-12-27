package com.github.mmo.game;


enum EnumCharacterQueryLoad
{
	characters,
	customizations;

	public static final int SIZE = Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static EnumCharacterQueryLoad forValue(int value)
	{
		return values()[value];
	}
}
