package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.*;
class CancelAutoRepeatSpell extends ClientPacket
{
	public CancelAutoRepeatSpell(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
	}
}
