package com.github.mmo.game.entity.dynamic;
public enum DynamicObjectType
{
	Portal(0x0), // unused
	AreaSpell(0x1),
	FarsightFocus(0x2);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, DynamicObjectType> mappings;
	private static java.util.HashMap<Integer, DynamicObjectType> getMappings()
	{
		if (mappings == null)
		{
			synchronized (DynamicObjectType.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, DynamicObjectType>();
				}
			}
		}
		return mappings;
	}

	private DynamicObjectType(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static DynamicObjectType forValue(int value)
	{
		return getMappings().get(value);
	}
}
