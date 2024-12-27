package com.github.mmo.game.battlepay;

public enum ProductListResult
{
	Available(0),
	LockUnk1(1),
	LockUnk2(2),
	RegionLocked(3);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, ProductListResult> mappings;
	private static java.util.HashMap<Integer, ProductListResult> getMappings()
	{
		if (mappings == null)
		{
			synchronized (ProductListResult.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, ProductListResult>();
				}
			}
		}
		return mappings;
	}

	private ProductListResult(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static ProductListResult forValue(int value)
	{
		return getMappings().get(value);
	}
}
