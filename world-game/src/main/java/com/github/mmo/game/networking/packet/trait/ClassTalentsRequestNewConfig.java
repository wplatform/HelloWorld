package com.github.mmo.game.networking.packet.trait;

import com.github.mmo.game.networking.*;
class ClassTalentsRequestNewConfig extends ClientPacket
{
	public TraitconfigPacket config = new traitConfigPacket();

	public ClassTalentsRequestNewConfig(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		config.read(this);
	}
}
