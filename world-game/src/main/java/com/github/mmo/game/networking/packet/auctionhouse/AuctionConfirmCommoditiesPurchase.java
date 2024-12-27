package com.github.mmo.game.networking.packet.auctionhouse;

import com.github.mmo.game.networking.*;

class AuctionConfirmCommoditiesPurchase extends ClientPacket
{
	public ObjectGuid auctioneer = ObjectGuid.EMPTY;
	public int itemID;
	public int quantity;
	public AddOnInfo taintedBy = null;

	public AuctionConfirmCommoditiesPurchase(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		auctioneer = this.readPackedGuid();
		itemID = this.readInt32();
		quantity = this.readUInt();

		if (this.readBit())
		{
			taintedBy = new AddOnInfo();
			taintedBy.getValue().read(this);
		}
	}
}
