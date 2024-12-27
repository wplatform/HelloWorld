package com.github.mmo.game;


import java.util.HashMap;

public enum DisableType
{
	spell(0),
	quest(1),
	Map(2),
	Battleground(3),
	criteria(4),
	OutdoorPVP(5),
	VMAP(6),
	MMAP(7),
	LFGMap(8),
	max(9);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static HashMap<Integer, DisableType> mappings;
	private static HashMap<Integer, DisableType> getMappings()
	{
		if (mappings == null)
		{
			synchronized (DisableType.class)
			{
				if (mappings == null)
				{
					mappings = new HashMap<Integer, DisableType>();
				}
			}
		}
		return mappings;
	}

	private DisableType(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static DisableType forValue(int value)
	{
		return getMappings().get(value);
	}
}
