package com.github.mmo.game.battlepay;

public enum BattlePayDistribution
{
	// character boost
	CHARACTER_BOOST(2),
	CHARACTER_BOOST_ALLOW(1),
	CHARACTER_BOOST_CHOOSED(2),
	CHARACTER_BOOST_ITEMS(3),
	CHARACTER_BOOST_APPLIED(4),
	CHARACTER_BOOST_TEXT_ID(88),
	CHARACTER_BOOST_SPEC_MASK(0xFFF),
	CHARACTER_BOOST_FACTION_ALLIANCE(0x1000000);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, BattlePayDistribution> mappings;
	private static java.util.HashMap<Integer, BattlePayDistribution> getMappings()
	{
		if (mappings == null)
		{
			synchronized (BattlePayDistribution.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, BattlePayDistribution>();
				}
			}
		}
		return mappings;
	}

	private BattlePayDistribution(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static BattlePayDistribution forValue(int value)
	{
		return getMappings().get(value);
	}
}
