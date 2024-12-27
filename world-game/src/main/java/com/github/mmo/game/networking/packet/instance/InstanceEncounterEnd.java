package com.github.mmo.game.networking.packet.instance;
import com.github.mmo.game.networking.ServerPacket;
public class InstanceEncounterEnd extends ServerPacket
{
	public InstanceEncounterEnd()
	{
		super(ServerOpcode.InstanceEncounterEnd, ConnectionType.instance);
	}

	@Override
	public void write()
	{
	}
}
