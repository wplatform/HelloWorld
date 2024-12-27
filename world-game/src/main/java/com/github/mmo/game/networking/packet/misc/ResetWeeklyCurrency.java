package com.github.mmo.game.networking.packet.misc;


public class ResetWeeklyCurrency extends ServerPacket
{
	public ResetWeeklyCurrency()
	{
		super(ServerOpcode.ResetWeeklyCurrency, ConnectionType.instance);
	}

	@Override
	public void write()
	{
	}
}
