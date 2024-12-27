package com.github.mmo.game.battleground.zones;



import java.util.*;

enum SAObjectives
{
	gatesDestroyed(231),
	demolishersDestroyed(232);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static HashMap<Integer, SAObjectives> mappings;
	private static HashMap<Integer, SAObjectives> getMappings()
	{
		if (mappings == null)
		{
			synchronized (SAObjectives.class)
			{
				if (mappings == null)
				{
					mappings = new HashMap<Integer, SAObjectives>();
				}
			}
		}
		return mappings;
	}

	private SAObjectives(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static SAObjectives forValue(int value)
	{
		return getMappings().get(value);
	}
}

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
///#endregion

