package com.github.mmo.game.networking.packet.taxi;
import com.github.mmo.game.networking.ServerPacket;
public class NewTaxiPath extends ServerPacket
{
	public NewTaxiPath()
	{
		super(ServerOpcode.NewTaxiPath);
	}

	@Override
	public void write()
	{
	}
}
