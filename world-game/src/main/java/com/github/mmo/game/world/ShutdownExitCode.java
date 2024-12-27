package com.github.mmo.game.world;
public enum ShutdownExitCode
{
	Shutdown(0),
	error(1),
	RESTART(2);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, ShutdownExitCode> mappings;
	private static java.util.HashMap<Integer, ShutdownExitCode> getMappings()
	{
		if (mappings == null)
		{
			synchronized (ShutdownExitCode.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, ShutdownExitCode>();
				}
			}
		}
		return mappings;
	}

	private ShutdownExitCode(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static ShutdownExitCode forValue(int value)
	{
		return getMappings().get(value);
	}
}
