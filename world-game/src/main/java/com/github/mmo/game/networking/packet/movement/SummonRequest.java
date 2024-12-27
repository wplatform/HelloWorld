package com.github.mmo.game.networking.packet.movement;
import com.github.mmo.game.networking.ServerPacket;
public class SummonRequest extends ServerPacket
{
	public enum SummonReason
	{
		spell(0),
		Scenario(1);

		public static final int SIZE = Integer.SIZE;

		private int intValue;
		private static java.util.HashMap<Integer, SummonReason> mappings;
		private static java.util.HashMap<Integer, SummonReason> getMappings()
		{
			if (mappings == null)
			{
				synchronized (SummonReason.class)
				{
					if (mappings == null)
					{
						mappings = new java.util.HashMap<Integer, SummonReason>();
					}
				}
			}
			return mappings;
		}

		private SummonReason(int value)
		{
			intValue = value;
			getMappings().put(value, this);
		}

		public int getValue()
		{
			return intValue;
		}

		public static SummonReason forValue(int value)
		{
			return getMappings().get(value);
		}
	}

	public ObjectGuid summonerGUID = ObjectGuid.EMPTY;
	public int summonerVirtualRealmAddress;
	public int areaID;
	public Summonreason reason = SummonReason.values()[0];
	public boolean skipStartingArea;
	public SummonRequest()
	{
		super(ServerOpcode.SummonRequest, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeGuid(summonerGUID);
		this.writeInt32(summonerVirtualRealmAddress);
		this.writeInt32(areaID);
		this.writeInt8((byte)reason.getValue());
		this.writeBit(skipStartingArea);
		this.flushBits();
	}
}
