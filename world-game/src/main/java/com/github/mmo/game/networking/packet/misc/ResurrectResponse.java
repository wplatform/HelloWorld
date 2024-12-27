package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.*;

public class ResurrectResponse extends ClientPacket
{
	public ObjectGuid resurrecter = ObjectGuid.EMPTY;
	public int response;
	public ResurrectResponse(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		resurrecter = this.readPackedGuid();
		response = this.readUInt();
	}
}
