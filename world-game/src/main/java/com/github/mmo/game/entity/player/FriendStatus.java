package com.github.mmo.game.entity.player;
public enum FriendStatus
{
	Offline(0x00),
	online(0x01),
	AFK(0x02),
	DND(0x04),
	RAF(0x08);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, FriendStatus> mappings;
	private static java.util.HashMap<Integer, FriendStatus> getMappings()
	{
		if (mappings == null)
		{
			synchronized (FriendStatus.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, FriendStatus>();
				}
			}
		}
		return mappings;
	}

	private FriendStatus(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static FriendStatus forValue(int value)
	{
		return getMappings().get(value);
	}
}
