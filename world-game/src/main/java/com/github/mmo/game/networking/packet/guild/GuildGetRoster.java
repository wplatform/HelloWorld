package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;
public class GuildGetRoster extends ClientPacket
{
	public GuildGetRoster(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
	}
}
