package com.github.mmo.game.networking.packet.bpay;

import com.github.mmo.game.networking.WorldPacket;

public final class GetProductList extends ClientPacket
{
	public GetProductList(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
	}
}
