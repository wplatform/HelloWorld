package com.github.mmo.game.networking.packet.pet;

import com.github.mmo.game.networking.*;

class CancelModSpeedNoControlAuras extends ClientPacket
{
	public ObjectGuid targetGUID = ObjectGuid.EMPTY;

	public CancelModSpeedNoControlAuras(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		targetGUID = this.readPackedGuid();
	}
}