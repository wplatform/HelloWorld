package com.github.mmo.game.networking.packet.battlepet;
import com.github.mmo.game.networking.ServerPacket;
public class BattlePetJournalLockAcquired extends ServerPacket
{
	public BattlePetJournalLockAcquired()
	{
		super(ServerOpcode.BattlePetJournalLockAcquired);
	}

	@Override
	public void write()
	{
	}
}
