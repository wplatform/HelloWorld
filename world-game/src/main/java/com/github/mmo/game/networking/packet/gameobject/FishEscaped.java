package com.github.mmo.game.networking.packet.gameobject;
import com.github.mmo.game.networking.ServerPacket;
public class FishEscaped extends ServerPacket
{
	public FishEscaped()
	{
		super(ServerOpcode.FishEscaped);
	}

	@Override
	public void write()
	{
	}
}
