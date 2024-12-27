package com.github.mmo.game.movement;



public enum NavTerrainFlag
{
	empty(0x00),
	ground(1 << (NavArea.MaxValue - NavArea.ground)),
	GroundSteep(1 << (NavArea.MaxValue - NavArea.GroundSteep)),
	Water(1 << (NavArea.MaxValue - NavArea.Water)),
	MagmaSlime(1 << (NavArea.MaxValue - NavArea.MagmaSlime));

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, NavTerrainFlag> mappings;
	private static java.util.HashMap<Integer, NavTerrainFlag> getMappings()
	{
		if (mappings == null)
		{
			synchronized (NavTerrainFlag.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, NavTerrainFlag>();
				}
			}
		}
		return mappings;
	}

	private NavTerrainFlag(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static NavTerrainFlag forValue(int value)
	{
		return getMappings().get(value);
	}
}
