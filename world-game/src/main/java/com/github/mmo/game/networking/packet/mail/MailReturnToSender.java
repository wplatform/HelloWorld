package com.github.mmo.game.networking.packet.mail;

import com.github.mmo.game.networking.*;

public class MailReturnToSender extends ClientPacket
{
	public long mailID;
	public ObjectGuid senderGUID = ObjectGuid.EMPTY;
	public MailReturnToSender(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		mailID = this.readUInt64();
		senderGUID = this.readPackedGuid();
	}
}
