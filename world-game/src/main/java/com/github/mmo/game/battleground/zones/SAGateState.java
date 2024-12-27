package com.github.mmo.game.battleground.zones;



import java.util.*;

enum SAGateState
{
	// alliance is defender
	AllianceGateOk(1),
	AllianceGateDamaged(2),
	AllianceGateDestroyed(3),

	// horde is defender
	HordeGateOk(4),
	HordeGateDamaged(5),
	HordeGateDestroyed(6);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static HashMap<Integer, SAGateState> mappings;
	private static HashMap<Integer, SAGateState> getMappings()
	{
		if (mappings == null)
		{
			synchronized (SAGateState.class)
			{
				if (mappings == null)
				{
					mappings = new HashMap<Integer, SAGateState>();
				}
			}
		}
		return mappings;
	}

	private SAGateState(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static SAGateState forValue(int value)
	{
		return getMappings().get(value);
	}
}
