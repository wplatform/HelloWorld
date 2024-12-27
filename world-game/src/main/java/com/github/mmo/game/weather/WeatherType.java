package com.github.mmo.game.weather;
public enum WeatherType
{
	Fine(0),
	Rain(1),
	Snow(2),
	Storm(3),
	Thunders(86),
	BlackRain(90);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, WeatherType> mappings;
	private static java.util.HashMap<Integer, WeatherType> getMappings()
	{
		if (mappings == null)
		{
			synchronized (WeatherType.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, WeatherType>();
				}
			}
		}
		return mappings;
	}

	private WeatherType(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static WeatherType forValue(int value)
	{
		return getMappings().get(value);
	}
}
