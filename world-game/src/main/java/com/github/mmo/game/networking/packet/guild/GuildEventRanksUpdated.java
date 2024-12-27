package com.github.mmo.game.networking.packet.guild;


public class GuildEventRanksUpdated extends ServerPacket
{
	public GuildEventRanksUpdated()
	{
		super(ServerOpcode.GuildEventRanksUpdated);
	}

	@Override
	public void write()
	{
	}
}
