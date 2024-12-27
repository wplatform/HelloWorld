package com.github.mmo.game.pvp;



enum OutdoorPvPHPTowerType
{
	BrokenHill(0),
	Overlook(1),
	Stadium(2),
	Num(3);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, OutdoorPvPHPTowerType> mappings;
	private static java.util.HashMap<Integer, OutdoorPvPHPTowerType> getMappings()
	{
		if (mappings == null)
		{
			synchronized (OutdoorPvPHPTowerType.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, OutdoorPvPHPTowerType>();
				}
			}
		}
		return mappings;
	}

	private OutdoorPvPHPTowerType(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static OutdoorPvPHPTowerType forValue(int value)
	{
		return getMappings().get(value);
	}
}
