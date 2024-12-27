package com.github.mmo.game.networking.packet.battlepet;

import com.github.mmo.game.networking.WorldPacket;

class BattlePetUpdateNotify extends ClientPacket
{
    public ObjectGuid petGuid = ObjectGuid.EMPTY;

	public BattlePetUpdateNotify(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        petGuid = this.readPackedGuid();
	}
}
