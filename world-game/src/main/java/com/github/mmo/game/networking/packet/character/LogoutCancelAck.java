package com.github.mmo.game.networking.packet.character;


public class LogoutCancelAck extends ServerPacket
{
	public LogoutCancelAck()
	{
		super(ServerOpcode.LogoutCancelAck, ConnectionType.instance);
	}

	@Override
	public void write()
	{
	}
}
