package com.github.mmo.game.networking.packet.query;

import com.github.mmo.game.networking.*;

public class QueryPlayerNames extends ClientPacket
{
	public ObjectGuid[] players;
	public QueryPlayerNames(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		players = new ObjectGuid[this.readInt32()];

		for (var i = 0; i < players.length; ++i)
		{
			Players[i] = this.readPackedGuid();
		}
	}
}

//Structs

