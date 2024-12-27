package com.github.mmo.game.networking.packet.pet;

import com.github.mmo.game.networking.WorldPacket;

class PetStopAttack extends ClientPacket
{
    public ObjectGuid petGUID = ObjectGuid.EMPTY;
	public PetStopAttack(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        petGUID = this.readPackedGuid();
	}
}
