package com.github.mmo.game.networking.packet.duel;


public class DuelInBounds extends ServerPacket
{
	public DuelInBounds()
	{
		super(ServerOpcode.DuelInBounds, ConnectionType.instance);
	}

	@Override
	public void write()
	{
	}
}
