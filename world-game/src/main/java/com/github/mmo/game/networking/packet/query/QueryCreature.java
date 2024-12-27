package com.github.mmo.game.networking.packet.query;

import com.github.mmo.game.networking.*;
public class QueryCreature extends ClientPacket
{
	public int creatureID;
	public QueryCreature(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		creatureID = this.readUInt();
	}
}
