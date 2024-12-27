package com.github.mmo.game.networking.packet.collection;

public enum CollectionType
{
	NONE(-1),
	Toybox(1),
	Appearance(3),
	TransmogSet(4);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, CollectionType> mappings;
	private static java.util.HashMap<Integer, CollectionType> getMappings()
	{
		if (mappings == null)
		{
			synchronized (CollectionType.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, CollectionType>();
				}
			}
		}
		return mappings;
	}

	private CollectionType(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static CollectionType forValue(int value)
	{
		return getMappings().get(value);
	}
}
