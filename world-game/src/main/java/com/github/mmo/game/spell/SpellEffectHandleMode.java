package com.github.mmo.game.spell;
public enum SpellEffectHandleMode
{
	Launch,
	LaunchTarget,
	hit,
	HitTarget;

	public static final int SIZE = Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static SpellEffectHandleMode forValue(int value)
	{
		return values()[value];
	}
}
