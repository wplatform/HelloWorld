package com.github.mmo.game.networking.packet.pet;

import com.github.mmo.game.networking.*;

class PetAbandon extends ClientPacket
{
    public ObjectGuid pet = ObjectGuid.EMPTY;
	public PetAbandon(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        pet = this.readPackedGuid();
	}
}