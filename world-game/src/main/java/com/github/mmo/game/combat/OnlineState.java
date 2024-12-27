package com.github.mmo.game.combat;

public enum OnlineState
{
	online(2),
	Suppressed(1),
	Offline(0);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, OnlineState> mappings;
	private static java.util.HashMap<Integer, OnlineState> getMappings()
	{
		if (mappings == null)
		{
			synchronized (OnlineState.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, OnlineState>();
				}
			}
		}
		return mappings;
	}

	private OnlineState(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static OnlineState forValue(int value)
	{
		return getMappings().get(value);
	}
}
