package com.github.mmo.game.networking.packet.character;


public class BarberShopResult extends ServerPacket
{
	public enum ResultEnum
	{
		success(0),
		NoMoney(1),
		NotOnChair(2),
		NoMoney2(3);

		public static final int SIZE = Integer.SIZE;

		private int intValue;
		private static java.util.HashMap<Integer, ResultEnum> mappings;
		private static java.util.HashMap<Integer, ResultEnum> getMappings()
		{
			if (mappings == null)
			{
				synchronized (ResultEnum.class)
				{
					if (mappings == null)
					{
						mappings = new java.util.HashMap<Integer, ResultEnum>();
					}
				}
			}
			return mappings;
		}

		private ResultEnum(int value)
		{
			intValue = value;
			getMappings().put(value, this);
		}

		public int getValue()
		{
			return intValue;
		}

		public static ResultEnum forValue(int value)
		{
			return getMappings().get(value);
		}
	}

	public resultEnum result = ResultEnum.values()[0];

	public BarberShopResult(ResultEnum result)
	{
		super(ServerOpcode.BarberShopResult);
		result = result;
	}

	@Override
	public void write()
	{
        this.writeInt32(result.getValue());
	}
}
