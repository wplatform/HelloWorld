package com.github.mmo.game.networking.packet.who;

import com.github.mmo.game.networking.*;
public class WhoIsRequest extends ClientPacket
{
	public String charName;
	public WhoIsRequest(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		charName = this.readString(this.<Integer>readBit(6));
	}
}
