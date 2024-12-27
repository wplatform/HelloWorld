package com.github.mmo.game.networking.packet.blackmarket;

import com.github.mmo.game.networking.*;

class BlackMarketOpen extends ClientPacket
{
	public ObjectGuid guid = ObjectGuid.EMPTY;
	public BlackMarketOpen(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		guid = this.readPackedGuid();
	}
}
