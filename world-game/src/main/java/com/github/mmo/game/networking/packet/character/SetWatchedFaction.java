package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.networking.*;
class SetWatchedFaction extends ClientPacket
{
	public int factionIndex;
	public SetWatchedFaction(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		factionIndex = this.readUInt();
	}
}