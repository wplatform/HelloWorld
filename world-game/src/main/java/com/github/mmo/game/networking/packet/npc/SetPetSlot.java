package com.github.mmo.game.networking.packet.npc;

import com.github.mmo.game.networking.*;

class SetPetSlot extends ClientPacket
{
	public ObjectGuid stableMaster = ObjectGuid.EMPTY;
	public int petNumber;
	public byte destSlot;
	public SetPetSlot(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		petNumber = this.readUInt();
		destSlot = this.readUInt8();
		stableMaster = this.readPackedGuid();
	}
}
