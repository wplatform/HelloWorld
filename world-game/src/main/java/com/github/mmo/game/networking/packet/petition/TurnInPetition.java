package com.github.mmo.game.networking.packet.petition;

import com.github.mmo.game.networking.WorldPacket;

public class TurnInPetition extends ClientPacket
{
    public ObjectGuid item = ObjectGuid.EMPTY;
	public TurnInPetition(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        item = this.readPackedGuid();
	}
}
