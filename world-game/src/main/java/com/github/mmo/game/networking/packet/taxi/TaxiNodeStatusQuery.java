package com.github.mmo.game.networking.packet.taxi;

import com.github.mmo.game.networking.*;

class TaxiNodeStatusQuery extends ClientPacket
{
    public ObjectGuid unitGUID = ObjectGuid.EMPTY;
	public TaxiNodeStatusQuery(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        unitGUID = this.readPackedGuid();
	}
}
