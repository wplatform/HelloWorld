package com.github.mmo.game.entity.player;
public enum CharDeleteMethod
{
	remove(0), // Completely remove from the database

	Unlink(1); // The character gets unlinked from the account,
	// the name gets freed up and appears as deleted ingame

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, CharDeleteMethod> mappings;
	private static java.util.HashMap<Integer, CharDeleteMethod> getMappings()
	{
		if (mappings == null)
		{
			synchronized (CharDeleteMethod.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, CharDeleteMethod>();
				}
			}
		}
		return mappings;
	}

	private CharDeleteMethod(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static CharDeleteMethod forValue(int value)
	{
		return getMappings().get(value);
	}
}
