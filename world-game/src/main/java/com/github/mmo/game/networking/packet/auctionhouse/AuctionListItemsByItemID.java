package com.github.mmo.game.networking.packet.auctionhouse;

import com.github.mmo.game.networking.*;

class AuctionListItemsByItemID extends ClientPacket
{
	public ObjectGuid auctioneer = ObjectGuid.EMPTY;
	public int itemID;
	public int suffixItemNameDescriptionID;
	public int offset;
	public AddOnInfo taintedBy = null;
	public Array<AuctionSortDef> sorts = new Array<AuctionSortDef>(2);

	public AuctionListItemsByItemID(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		auctioneer = this.readPackedGuid();
		itemID = this.readUInt();
		suffixItemNameDescriptionID = this.readInt32();
		offset = this.readUInt();

		if (this.readBit())
		{
			taintedBy = new AddOnInfo();
		}

		var sortCount = this.<Integer>readBit(2);

		for (var i = 0; i < sortCount; ++i)
		{
			sorts.set(i, new AuctionSortDef(this));
		}

		if (taintedBy != null)
		{
			taintedBy.getValue().read(this);
		}
	}
}