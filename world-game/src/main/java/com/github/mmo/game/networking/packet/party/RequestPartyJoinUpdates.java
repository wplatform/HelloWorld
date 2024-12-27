package com.github.mmo.game.networking.packet.party;

import com.github.mmo.game.networking.*;
class RequestPartyJoinUpdates extends ClientPacket
{
	public byte partyIndex;
	public RequestPartyJoinUpdates(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		partyIndex = this.readByte();
	}
}
