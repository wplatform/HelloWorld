package com.github.mmo.game.networking.packet.battlepet;

import com.github.mmo.game.networking.*;

class BattlePetSummon extends ClientPacket
{
	public ObjectGuid petGuid = ObjectGuid.EMPTY;
	public BattlePetSummon(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		petGuid = this.readPackedGuid();
	}
}
