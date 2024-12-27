package com.github.mmo.game.networking.packet.trade;

import com.github.mmo.game.networking.*;
public class UnacceptTrade extends ClientPacket
{
	public UnacceptTrade(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
	}
}
