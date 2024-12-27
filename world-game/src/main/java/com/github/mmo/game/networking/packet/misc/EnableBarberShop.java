package com.github.mmo.game.networking.packet.misc;


public class EnableBarberShop extends ServerPacket
{
	public EnableBarberShop()
	{
		super(ServerOpcode.EnableBarberShop);
	}

	@Override
	public void write()
	{
	}
}
