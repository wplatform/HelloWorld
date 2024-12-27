package com.github.mmo.game.networking.packet.mail;

import com.github.mmo.game.networking.*;

public class MailTakeMoney extends ClientPacket
{
	public ObjectGuid mailbox = ObjectGuid.EMPTY;
	public long mailID;
	public long money;
	public MailTakeMoney(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		mailbox = this.readPackedGuid();
		mailID = this.readUInt64();
		money = this.readUInt64();
	}
}
