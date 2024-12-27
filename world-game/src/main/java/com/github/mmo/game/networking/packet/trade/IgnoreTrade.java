package com.github.mmo.game.networking.packet.trade;

import com.github.mmo.game.networking.*;
public class IgnoreTrade extends ClientPacket
{
	public IgnoreTrade(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
	}
}
