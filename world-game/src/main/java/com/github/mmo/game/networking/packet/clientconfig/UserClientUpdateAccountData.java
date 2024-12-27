package com.github.mmo.game.networking.packet.clientconfig;



import com.github.mmo.game.networking.*;

public class UserClientUpdateAccountData extends ClientPacket
{
	public ObjectGuid playerGuid = ObjectGuid.EMPTY;
	public long time; // UnixTime
	public int size; // decompressed size
	public AccountdataTypes dataType = AccountDataTypes.forValue(0);
	public ByteBuffer compressedData;
	public UserClientUpdateAccountData(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		playerGuid = this.readPackedGuid();
		time = this.readInt64();
		size = this.readUInt();
		dataType = AccountDataTypes.forValue(this.<Integer>readBit(4));

		var compressedSize = this.readUInt();

		if (compressedSize != 0)
		{
			compressedData = new byteBuffer(this.readBytes(compressedSize));
		}
	}
}
