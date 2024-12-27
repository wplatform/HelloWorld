package com.github.mmo.game.networking.packet.item;

import com.github.mmo.game.networking.*;
final class ItemPurchaseRefundItem
{
	public void write(WorldPacket data)
	{
		data.writeInt32(itemID);
		data.writeInt32(itemCount);
	}

	public int itemID;
	public int itemCount;

	public ItemPurchaseRefundItem clone()
	{
		ItemPurchaseRefundItem varCopy = new ItemPurchaseRefundItem();

		varCopy.itemID = this.itemID;
		varCopy.itemCount = this.itemCount;

		return varCopy;
	}
}
