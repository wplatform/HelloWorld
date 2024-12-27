package com.github.mmo.game.battleground.zones;



import java.util.*;

enum EotSPointState
{
	NoOwner(0),
	Uncontrolled(0),
	UnderControl(3);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static HashMap<Integer, EotSPointState> mappings;
	private static HashMap<Integer, EotSPointState> getMappings()
	{
		if (mappings == null)
		{
			synchronized (EotSPointState.class)
			{
				if (mappings == null)
				{
					mappings = new HashMap<Integer, EotSPointState>();
				}
			}
		}
		return mappings;
	}

	private EotSPointState(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static EotSPointState forValue(int value)
	{
		return getMappings().get(value);
	}
}
