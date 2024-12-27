package com.github.mmo.game.networking.packet.mythicplus;


public class MythicPlusSeasonData extends ServerPacket
{
	public boolean seasonActive;

	public MythicPlusSeasonData()
	{
		super(ServerOpcode.MythicPlusSeasonData);
	}

	@Override
	public void write()
	{
		this.write(seasonActive);
	}
}
