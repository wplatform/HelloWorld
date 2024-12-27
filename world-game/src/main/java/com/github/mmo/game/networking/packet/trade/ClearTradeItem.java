package com.github.mmo.game.networking.packet.trade;

import com.github.mmo.game.networking.*;
public class ClearTradeItem extends ClientPacket
{
	public byte tradeSlot;
	public ClearTradeItem(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        tradeSlot = this.readUInt8();
	}
}
