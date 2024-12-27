package com.github.mmo.game.networking.packet.npc;

import com.github.mmo.game.networking.*;

class RequestStabledPets extends ClientPacket
{
    public ObjectGuid stableMaster = ObjectGuid.EMPTY;
	public RequestStabledPets(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        stableMaster = this.readPackedGuid();
	}
}
