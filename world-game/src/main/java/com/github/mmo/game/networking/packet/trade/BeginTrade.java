package com.github.mmo.game.networking.packet.trade;

import com.github.mmo.game.networking.*;
public class BeginTrade extends ClientPacket
{
	public BeginTrade(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
	}
}
