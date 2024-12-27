package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;
public class GuildLeave extends ClientPacket
{
	public GuildLeave(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
	}
}
