package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.*;
class FarSight extends ClientPacket
{
	public boolean enable;
	public FarSight(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		enable = this.readBit();
	}
}