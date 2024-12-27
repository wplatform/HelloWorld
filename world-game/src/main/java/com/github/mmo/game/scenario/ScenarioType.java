package com.github.mmo.game.scenario;
enum ScenarioType
{
	Scenario(0),
	ChallengeMode(1),
	Solo(2),
	Dungeon(10);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, ScenarioType> mappings;
	private static java.util.HashMap<Integer, ScenarioType> getMappings()
	{
		if (mappings == null)
		{
			synchronized (ScenarioType.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, ScenarioType>();
				}
			}
		}
		return mappings;
	}

	private ScenarioType(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static ScenarioType forValue(int value)
	{
		return getMappings().get(value);
	}
}
