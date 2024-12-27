package com.github.mmo.game.networking.packet.item;

import com.github.mmo.game.networking.*;

public class GetItemPurchaseData extends ClientPacket
{
    public ObjectGuid itemGUID = ObjectGuid.EMPTY;
	public GetItemPurchaseData(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        itemGUID = this.readPackedGuid();
	}
}
