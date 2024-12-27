package com.github.mmo.game.networking.packet.lfg;
import com.github.mmo.game.networking.ServerPacket;
public class LfgBootPlayer extends ServerPacket
{
	public LfgBootinfo info = new lfgBootInfo();
	public LfgBootPlayer()
	{
		super(ServerOpcode.LfgBootPlayer, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		info.write(this);
	}
}
