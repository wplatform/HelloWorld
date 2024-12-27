package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.*;
class SetWarMode extends ClientPacket
{
	public boolean enable;
	public SetWarMode(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        enable = this.readBit();
	}
}
