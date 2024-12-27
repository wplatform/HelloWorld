package com.github.mmo.game.networking.packet.battleground;

import com.github.mmo.game.networking.*;
class GetPVPOptionsEnabled extends ClientPacket
{
	public GetPVPOptionsEnabled(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
	}
}
