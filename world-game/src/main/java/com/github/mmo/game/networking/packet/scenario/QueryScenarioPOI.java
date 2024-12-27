package com.github.mmo.game.networking.packet.scenario;

import com.github.mmo.game.networking.*;

class QueryScenarioPOI extends ClientPacket
{
	public Array<Integer> missingScenarioPOIs = new Array<Integer>(50);
	public QueryScenarioPOI(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        var count = this.readUInt();

		for (var i = 0; i < count; ++i)
		{
            missingScenarioPOIs.set(i, this.readInt32());
		}
	}
}
