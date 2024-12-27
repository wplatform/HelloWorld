package com.github.mmo.game.movement.model;



public enum EvaluationMode
{
	Linear,
	Catmullrom,
	Bezier3_Unused,
	UninitializedMode,
	ModesEnd;

	public static final int SIZE = Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static EvaluationMode forValue(int value)
	{
		return values()[value];
	}
}
