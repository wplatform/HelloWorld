package com.github.mmo.game.combat;

public enum TauntState
{
	Detaunt(0),
	NONE(1),
	Taunt(2);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, TauntState> mappings;
	private static java.util.HashMap<Integer, TauntState> getMappings()
	{
		if (mappings == null)
		{
			synchronized (TauntState.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, TauntState>();
				}
			}
		}
		return mappings;
	}

	private TauntState(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static TauntState forValue(int value)
	{
		return getMappings().get(value);
	}
}
