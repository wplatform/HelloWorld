package com.github.mmo.game;




public class CleaningFlags
{
	public static final cleaningFlags ACHIEVEMENTPROGRESS = new cleaningFlags(0x1);
	public static final CleaningFlags SKILLS = new cleaningFlags(0x2);
	public static final CleaningFlags SPELLS = new cleaningFlags(0x4);
	public static final CleaningFlags TALENTS = new cleaningFlags(0x8);
	public static final CleaningFlags QUESTSTATUS = new cleaningFlags(0x10);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, CleaningFlags> mappings;
	private static java.util.HashMap<Integer, CleaningFlags> getMappings()
	{
		if (mappings == null)
		{
			synchronized (CleaningFlags.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, CleaningFlags>();
				}
			}
		}
		return mappings;
	}

	private cleaningFlags(int value)
	{
		intValue = value;
		synchronized (CleaningFlags.class)
		{
			getMappings().put(value, this);
		}
	}

	public int getValue()
	{
		return intValue;
	}

	public static CleaningFlags forValue(int value)
	{
		synchronized (CleaningFlags.class)
		{
			CleaningFlags enumObj = getMappings().get(value);
			if (enumObj == null)
			{
				return new cleaningFlags(value);
			}
			else
			{
				return enumObj;
			}
		}
	}
}
