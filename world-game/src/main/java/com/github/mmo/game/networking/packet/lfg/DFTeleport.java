package com.github.mmo.game.networking.packet.lfg;

import com.github.mmo.game.networking.*;
class DFTeleport extends ClientPacket
{
	public boolean teleportOut;
	public DFTeleport(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		teleportOut = this.readBit();
	}
}
