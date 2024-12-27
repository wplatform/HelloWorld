package com.github.mmo.game.networking.packet.trade;

import com.github.mmo.game.networking.*;
public class SetTradeGold extends ClientPacket
{
	public long coinage;
	public SetTradeGold(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		coinage = this.readUInt64();
	}
}
