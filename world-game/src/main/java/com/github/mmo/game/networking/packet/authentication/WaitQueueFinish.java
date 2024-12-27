package com.github.mmo.game.networking.packet.authentication;
import com.github.mmo.game.networking.ServerPacket;
public class WaitQueueFinish extends ServerPacket
{
	public WaitQueueFinish()
	{
		super(ServerOpcode.WaitQueueFinish);
	}

	@Override
	public void write()
	{
	}
}
