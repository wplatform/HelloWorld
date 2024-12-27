package com.github.mmo.game.networking.packet.instance;
import com.github.mmo.game.networking.ServerPacket;
public class InstanceEncounterInCombatResurrection extends ServerPacket
{
	public InstanceEncounterInCombatResurrection()
	{
		super(ServerOpcode.InstanceEncounterInCombatResurrection, ConnectionType.instance);
	}

	@Override
	public void write()
	{
	}
}
