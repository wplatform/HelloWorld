package com.github.mmo.game.networking.packet.npc;

import com.github.mmo.game.networking.WorldPacket;

class SpiritHealerActivate extends ClientPacket
{
    public ObjectGuid healer = ObjectGuid.EMPTY;
	public SpiritHealerActivate(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        healer = this.readPackedGuid();
	}
}
