package com.github.mmo.game.networking.packet.toy;

import com.github.mmo.game.networking.*;
class ToyClearFanfare extends ClientPacket
{
	public int itemID;
	public toyClearFanfare(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		itemID = this.readUInt();
	}
}
