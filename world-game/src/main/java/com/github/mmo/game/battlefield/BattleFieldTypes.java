package com.github.mmo.game.battlefield;



import java.util.*;


public enum BattleFieldTypes
{
	WinterGrasp(1),
	TolBarad(2),
	max(3);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static HashMap<Integer, BattleFieldTypes> mappings;
	private static HashMap<Integer, BattleFieldTypes> getMappings()
	{
		if (mappings == null)
		{
			synchronized (BattleFieldTypes.class)
			{
				if (mappings == null)
				{
					mappings = new HashMap<Integer, BattleFieldTypes>();
				}
			}
		}
		return mappings;
	}

	private BattleFieldTypes(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static BattleFieldTypes forValue(int value)
	{
		return getMappings().get(value);
	}
}
