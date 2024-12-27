package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.networking.*;

public class SetActiveMover extends ClientPacket
{
	public ObjectGuid activeMover = ObjectGuid.EMPTY;

	public SetActiveMover(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		activeMover = this.readPackedGuid();
	}
}
