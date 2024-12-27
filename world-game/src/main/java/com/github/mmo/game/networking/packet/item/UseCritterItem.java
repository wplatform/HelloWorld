package com.github.mmo.game.networking.packet.item;

import com.github.mmo.game.networking.*;

class UseCritterItem extends ClientPacket
{
    public ObjectGuid itemGuid = ObjectGuid.EMPTY;
	public UseCritterItem(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        itemGuid = this.readPackedGuid();
	}
}
