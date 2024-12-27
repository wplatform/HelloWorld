package com.github.mmo.game.networking.packet.authentication;
import com.github.mmo.game.networking.ServerPacket;
public class WaitQueueUpdate extends ServerPacket
{
	public AuthwaitInfo waitInfo = new authWaitInfo();
	public WaitQueueUpdate()
	{
		super(ServerOpcode.WaitQueueUpdate);
	}

	@Override
	public void write()
	{
		waitInfo.write(this);
	}
}
