package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.*;
class TogglePvP extends ClientPacket
{
	public TogglePvP(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
	}
}
