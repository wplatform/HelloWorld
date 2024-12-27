package com.github.mmo.game.battleground.zones;



// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
///#region Constants

enum WSGRewards
{
	Win(0),
	FlapCap(1),
	MapComplete(2),
	RewardNum(3);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, WSGRewards> mappings;
	private static java.util.HashMap<Integer, WSGRewards> getMappings()
	{
		if (mappings == null)
		{
			synchronized (WSGRewards.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, WSGRewards>();
				}
			}
		}
		return mappings;
	}

	private WSGRewards(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static WSGRewards forValue(int value)
	{
		return getMappings().get(value);
	}
}
