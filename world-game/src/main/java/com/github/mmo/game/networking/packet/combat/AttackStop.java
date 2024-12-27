package com.github.mmo.game.networking.packet.combat;

import com.github.mmo.game.networking.*;
public class AttackStop extends ClientPacket
{
	public attackStop(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
	}
}
