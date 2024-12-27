package com.github.mmo.game.networking.packet.auctionhouse;

import com.github.mmo.game.networking.*;

class AuctionPlaceBid extends ClientPacket
{
	public ObjectGuid auctioneer = ObjectGuid.EMPTY;
	public long bidAmount;
	public int auctionID;
	public AddOnInfo taintedBy = null;

	public AuctionPlaceBid(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		auctioneer = this.readPackedGuid();
		auctionID = this.readUInt();
		bidAmount = this.readUInt64();

		if (this.readBit())
		{
			taintedBy = new AddOnInfo();
			taintedBy.getValue().read(this);
		}
	}
}
