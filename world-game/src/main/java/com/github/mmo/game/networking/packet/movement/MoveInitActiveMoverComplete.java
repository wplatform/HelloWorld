package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.networking.*;
class MoveInitActiveMoverComplete extends ClientPacket
{
	public int ticks;

	public MoveInitActiveMoverComplete(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		ticks = this.readUInt();
	}
}