package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.networking.*;
class SetFactionAtWar extends ClientPacket
{
	public byte factionIndex;
	public SetFactionAtWar(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        factionIndex = this.readUInt8();
	}
}
