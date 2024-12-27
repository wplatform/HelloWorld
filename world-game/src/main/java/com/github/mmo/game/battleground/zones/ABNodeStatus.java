package com.github.mmo.game.battleground.zones;



import java.util.*;

enum ABNodeStatus
{
	Neutral(0),
	Contested(1),
	AllyContested(1),
	HordeContested(2),
	Occupied(3),
	AllyOccupied(3),
	HordeOccupied(4);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static HashMap<Integer, ABNodeStatus> mappings;
	private static HashMap<Integer, ABNodeStatus> getMappings()
	{
		if (mappings == null)
		{
			synchronized (ABNodeStatus.class)
			{
				if (mappings == null)
				{
					mappings = new HashMap<Integer, ABNodeStatus>();
				}
			}
		}
		return mappings;
	}

	private ABNodeStatus(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static ABNodeStatus forValue(int value)
	{
		return getMappings().get(value);
	}
}
