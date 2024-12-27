package com.github.mmo.game.networking.packet.vehicle;

import com.github.mmo.game.networking.*;

public class EjectPassenger extends ClientPacket
{
	public ObjectGuid passenger = ObjectGuid.EMPTY;
	public EjectPassenger(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		passenger = this.readPackedGuid();
	}
}
