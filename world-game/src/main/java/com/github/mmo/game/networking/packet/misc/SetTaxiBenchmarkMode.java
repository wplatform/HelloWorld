package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.*;
class SetTaxiBenchmarkMode extends ClientPacket
{
	public boolean enable;
	public SetTaxiBenchmarkMode(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		enable = this.readBit();
	}
}
