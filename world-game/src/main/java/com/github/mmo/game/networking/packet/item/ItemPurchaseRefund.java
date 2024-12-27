package com.github.mmo.game.networking.packet.item;

import com.github.mmo.game.networking.*;

class ItemPurchaseRefund extends ClientPacket
{
	public ObjectGuid itemGUID = ObjectGuid.EMPTY;
	public ItemPurchaseRefund(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		itemGUID = this.readPackedGuid();
	}
}
