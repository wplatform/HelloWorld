package com.github.mmo.game.networking.packet.trait;

import com.github.mmo.game.networking.*;
class ClassTalentsDeleteConfig extends ClientPacket
{
	public int configID;

	public ClassTalentsDeleteConfig(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		configID = this.readInt32();
	}
}