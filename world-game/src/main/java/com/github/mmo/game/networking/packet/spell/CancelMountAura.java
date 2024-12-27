package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.*;
class CancelMountAura extends ClientPacket
{
	public CancelMountAura(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
	}
}
