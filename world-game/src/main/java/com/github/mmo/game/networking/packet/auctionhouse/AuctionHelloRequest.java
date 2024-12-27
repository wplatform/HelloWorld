package com.github.mmo.game.networking.packet.auctionhouse;

import com.github.mmo.game.networking.*;

class AuctionHelloRequest extends ClientPacket
{
	public ObjectGuid guid = ObjectGuid.EMPTY;

	public AuctionHelloRequest(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		guid = this.readPackedGuid();
	}
}
