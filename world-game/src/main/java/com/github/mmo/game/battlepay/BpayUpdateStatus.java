package com.github.mmo.game.battlepay;

public enum BpayUpdateStatus
{
	Loading(9),
	Ready(6),
	finish(3);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, BpayUpdateStatus> mappings;
	private static java.util.HashMap<Integer, BpayUpdateStatus> getMappings()
	{
		if (mappings == null)
		{
			synchronized (BpayUpdateStatus.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, BpayUpdateStatus>();
				}
			}
		}
		return mappings;
	}

	private BpayUpdateStatus(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static BpayUpdateStatus forValue(int value)
	{
		return getMappings().get(value);
	}
}
