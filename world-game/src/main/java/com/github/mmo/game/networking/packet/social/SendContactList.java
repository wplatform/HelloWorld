package com.github.mmo.game.networking.packet.social;

import com.github.mmo.game.entity.player.SocialFlag;
import com.github.mmo.game.networking.*;

public class SendContactList extends ClientPacket
{
	public SocialFlag flags = SocialFlag.values()[0];
	public SendContactList(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		flags = SocialFlag.forValue(this.readUInt());
	}
}

//Structs

