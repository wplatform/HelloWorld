package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.*;
class SpellEmpowerRelease extends ClientPacket
{
	public int spellID;
	public SpellEmpowerRelease(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        spellID = this.readUInt();
	}
}
