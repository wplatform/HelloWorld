package com.github.mmo.game.networking.packet.misc;
import com.github.mmo.game.networking.ServerPacket;
public class SplashScreenShowLatest extends ServerPacket
{
	public int UISplashScreenID;
	public SplashScreenShowLatest()
	{
		super(ServerOpcode.SplashScreenShowLatest, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeInt32(UISplashScreenID);
	}
}
