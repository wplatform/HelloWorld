package com.github.mmo.game.networking.packet.mail;

import com.github.mmo.game.networking.*;

public class MailGetList extends ClientPacket
{
    public ObjectGuid mailbox = ObjectGuid.EMPTY;
	public MailGetList(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        mailbox = this.readPackedGuid();
	}
}

//Structs

