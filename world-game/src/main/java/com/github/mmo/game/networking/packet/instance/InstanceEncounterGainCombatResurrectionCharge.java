package com.github.mmo.game.networking.packet.instance;
import com.github.mmo.game.networking.ServerPacket;
public class InstanceEncounterGainCombatResurrectionCharge extends ServerPacket
{
	public int inCombatResCount;
	public int combatResChargeRecovery;
	public InstanceEncounterGainCombatResurrectionCharge()
	{
		super(ServerOpcode.InstanceEncounterGainCombatResurrectionCharge, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeInt32(inCombatResCount);
		this.writeInt32(combatResChargeRecovery);
	}
}
