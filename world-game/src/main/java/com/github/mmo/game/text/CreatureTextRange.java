package game;public enum CreatureTextRange
{
	NORMAL(0),
	area(1),
	Zone(2),
	Map(3),
	World(4),
	PERSONAL(5);

	public static final int SIZE = Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, CreatureTextRange> mappings;
	private static java.util.HashMap<Integer, CreatureTextRange> getMappings()
	{
		if (mappings == null)
		{
			synchronized (CreatureTextRange.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, CreatureTextRange>();
				}
			}
		}
		return mappings;
	}

	private CreatureTextRange(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static CreatureTextRange forValue(int value)
	{
		return getMappings().get(value);
	}
}