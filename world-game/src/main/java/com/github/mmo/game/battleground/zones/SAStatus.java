package com.github.mmo.game.battleground.zones;



import java.util.*;

enum SAStatus
{
	NotStarted(0),
	Warmup(1),
	RoundOne(2),
	SecondWarmup(3),
	RoundTwo(4),
	BonusRound(5);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static HashMap<Integer, SAStatus> mappings;
	private static HashMap<Integer, SAStatus> getMappings()
	{
		if (mappings == null)
		{
			synchronized (SAStatus.class)
			{
				if (mappings == null)
				{
					mappings = new HashMap<Integer, SAStatus>();
				}
			}
		}
		return mappings;
	}

	private SAStatus(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static SAStatus forValue(int value)
	{
		return getMappings().get(value);
	}
}
