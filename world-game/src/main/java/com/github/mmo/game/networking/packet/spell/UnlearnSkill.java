package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.*;
class UnlearnSkill extends ClientPacket
{
	public int skillLine;
	public UnlearnSkill(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        skillLine = this.readUInt();
	}
}
