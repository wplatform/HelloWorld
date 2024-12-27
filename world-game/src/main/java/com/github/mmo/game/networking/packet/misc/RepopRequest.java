package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.*;
public class RepopRequest extends ClientPacket
{
	public boolean checkInstance;
	public RepopRequest(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        checkInstance = this.readBit();
	}
}
