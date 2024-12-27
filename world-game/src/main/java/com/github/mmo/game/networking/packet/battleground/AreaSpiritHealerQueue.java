package com.github.mmo.game.networking.packet.battleground;

import com.github.mmo.game.networking.*;

public class AreaSpiritHealerQueue extends ClientPacket
{
    public ObjectGuid healerGuid = ObjectGuid.EMPTY;
	public AreaSpiritHealerQueue(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        healerGuid = this.readPackedGuid();
	}
}
