package com.github.mmo.game.networking.packet.party;

import com.github.mmo.game.networking.*;
class InitiateRolePoll extends ClientPacket
{
	public byte partyIndex;
	public InitiateRolePoll(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		partyIndex = this.readByte();
	}
}
