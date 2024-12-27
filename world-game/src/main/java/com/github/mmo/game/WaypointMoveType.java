package com.github.mmo.game;


public enum WaypointMoveType
{
	Walk,
	run,
	Land,
	Takeoff,

	max;

	public static final int SIZE = Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static WaypointMoveType forValue(int value)
	{
		return values()[value];
	}
}
