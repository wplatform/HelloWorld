package com.github.mmo.game.networking.packet.chat;

import com.github.mmo.game.networking.*;

class ChatReportIgnored extends ClientPacket
{
	public ObjectGuid ignoredGUID = ObjectGuid.EMPTY;
	public byte reason;
	public ChatReportIgnored(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		ignoredGUID = this.readPackedGuid();
		reason = this.readUInt8();
	}
}
