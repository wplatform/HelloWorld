package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.*;
class SetPvP extends ClientPacket
{
	public boolean enablePVP;
	public setPvP(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        enablePVP = this.readBit();
	}
}
