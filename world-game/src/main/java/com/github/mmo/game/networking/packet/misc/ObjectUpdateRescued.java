package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.*;

class ObjectUpdateRescued extends ClientPacket
{
    public ObjectGuid objectGUID = ObjectGuid.EMPTY;
	public ObjectUpdateRescued(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        objectGUID = this.readPackedGuid();
	}
}
