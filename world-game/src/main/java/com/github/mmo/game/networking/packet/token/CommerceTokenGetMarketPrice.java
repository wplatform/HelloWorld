package com.github.mmo.game.networking.packet.token;

import com.github.mmo.game.networking.*;
class CommerceTokenGetMarketPrice extends ClientPacket
{
	public int unkInt;
	public CommerceTokenGetMarketPrice(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		unkInt = this.readUInt();
	}
}
