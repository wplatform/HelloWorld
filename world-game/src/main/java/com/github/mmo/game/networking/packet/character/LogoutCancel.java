package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.networking.*;
public class LogoutCancel extends ClientPacket
{
	public LogoutCancel(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
	}
}