package com.github.mmo.game.battleground.zones;



enum WSGFlagState
{
	OnBase(1),
	OnPlayer(2),
	OnGround(3),
	WaitRespawn(4);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, WSGFlagState> mappings;
	private static java.util.HashMap<Integer, WSGFlagState> getMappings()
	{
		if (mappings == null)
		{
			synchronized (WSGFlagState.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, WSGFlagState>();
				}
			}
		}
		return mappings;
	}

	private WSGFlagState(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static WSGFlagState forValue(int value)
	{
		return getMappings().get(value);
	}
}
