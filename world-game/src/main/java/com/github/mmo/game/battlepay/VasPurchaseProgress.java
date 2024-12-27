package com.github.mmo.game.battlepay;

public enum VasPurchaseProgress
{
	Invalid(0),
	PrePurchase(1),
	PaymentPending(2),
	ApplyingLicense(3),
	WaitingOnQueue(4),
	Ready(5),
	ProcessingFactionChange(6),
	Complete(7);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, VasPurchaseProgress> mappings;
	private static java.util.HashMap<Integer, VasPurchaseProgress> getMappings()
	{
		if (mappings == null)
		{
			synchronized (VasPurchaseProgress.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, VasPurchaseProgress>();
				}
			}
		}
		return mappings;
	}

	private VasPurchaseProgress(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static VasPurchaseProgress forValue(int value)
	{
		return getMappings().get(value);
	}
}
