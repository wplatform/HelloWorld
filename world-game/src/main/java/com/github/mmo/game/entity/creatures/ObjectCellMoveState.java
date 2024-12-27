package com.github.mmo.game.entity;
public enum ObjectCellMoveState
{
	NONE, // not in move list
	active, // in move list
	inactive; // in move list but should not move

	public static final int SIZE = Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static ObjectCellMoveState forValue(int value)
	{
		return values()[value];
	}
}
