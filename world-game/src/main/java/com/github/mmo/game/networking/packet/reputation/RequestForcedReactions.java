package com.github.mmo.game.networking.packet.reputation;

import com.github.mmo.game.networking.*;
class RequestForcedReactions extends ClientPacket
{
	public RequestForcedReactions(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
	}
}
