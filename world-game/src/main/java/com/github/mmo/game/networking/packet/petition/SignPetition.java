package com.github.mmo.game.networking.packet.petition;

import com.github.mmo.game.networking.*;

public class SignPetition extends ClientPacket
{
	public ObjectGuid petitionGUID = ObjectGuid.EMPTY;
	public byte choice;
	public SignPetition(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		petitionGUID = this.readPackedGuid();
		choice = this.readUInt8();
	}
}
