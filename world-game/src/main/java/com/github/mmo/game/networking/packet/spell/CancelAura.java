package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.*;

class CancelAura extends ClientPacket
{
	public ObjectGuid casterGUID = ObjectGuid.EMPTY;
	public int spellID;
	public CancelAura(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		spellID = this.readUInt();
		casterGUID = this.readPackedGuid();
	}
}

//Structs

