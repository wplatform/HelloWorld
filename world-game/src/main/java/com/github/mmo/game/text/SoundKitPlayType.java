package game;public enum SoundKitPlayType
{
	NORMAL(0),
	ObjectSound(1),
	max(2);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, SoundKitPlayType> mappings;
	private static java.util.HashMap<Integer, SoundKitPlayType> getMappings()
	{
		if (mappings == null)
		{
			synchronized (SoundKitPlayType.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, SoundKitPlayType>();
				}
			}
		}
		return mappings;
	}

	private SoundKitPlayType(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static SoundKitPlayType forValue(int value)
	{
		return getMappings().get(value);
	}
}
