package com.github.mmo.game.networking.packet.pet;

import com.github.mmo.game.networking.*;

class DismissCritter extends ClientPacket
{
    public ObjectGuid critterGUID = ObjectGuid.EMPTY;
	public DismissCritter(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        critterGUID = this.readPackedGuid();
	}
}

//Structs
