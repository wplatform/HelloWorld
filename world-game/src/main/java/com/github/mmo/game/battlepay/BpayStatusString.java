package com.github.mmo.game.battlepay;

public enum BpayStatusString
{
	AtGoldLimit(14090),
	NeedToBeInGame(14091),
	TooHighLevel(14092),
	YouAlreadyOwnThat(14093),
	Level50Required(14094),
	ReachPrimaryProfessionLimit(14095),
	NotEnoughFreeBagSlots(14096);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, BpayStatusString> mappings;
	private static java.util.HashMap<Integer, BpayStatusString> getMappings()
	{
		if (mappings == null)
		{
			synchronized (BpayStatusString.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, BpayStatusString>();
				}
			}
		}
		return mappings;
	}

	private BpayStatusString(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static BpayStatusString forValue(int value)
	{
		return getMappings().get(value);
	}
}
