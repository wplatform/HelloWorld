package com.github.mmo.game.networking.packet.item;

import com.github.mmo.game.networking.*;

public class SellItem extends ClientPacket
{
	public ObjectGuid vendorGUID = ObjectGuid.EMPTY;
	public ObjectGuid itemGUID = ObjectGuid.EMPTY;
	public int amount;
	public SellItem(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		vendorGUID = this.readPackedGuid();
		itemGUID = this.readPackedGuid();
		amount = this.readUInt();
	}
}
