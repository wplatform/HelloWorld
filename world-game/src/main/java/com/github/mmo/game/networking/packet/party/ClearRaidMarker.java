package com.github.mmo.game.networking.packet.party;

import com.github.mmo.game.networking.*;
class ClearRaidMarker extends ClientPacket
{
	public byte markerId;
	public ClearRaidMarker(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		markerId = this.readUInt8();
	}
}
