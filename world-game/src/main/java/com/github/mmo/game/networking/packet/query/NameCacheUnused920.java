package com.github.mmo.game.networking.packet.query;

import com.github.mmo.game.networking.*;

public class NameCacheUnused920
{
	public int unused1;
	public ObjectGuid unused2 = ObjectGuid.EMPTY;
	public String unused3 = "";

	public final void write(WorldPacket data)
	{
		data.writeInt32(unused1);
		data.writeGuid(unused2);
		data.writeBits(unused3.GetByteCount(), 7);
		data.flushBits();

		data.writeString(unused3);
	}
}
