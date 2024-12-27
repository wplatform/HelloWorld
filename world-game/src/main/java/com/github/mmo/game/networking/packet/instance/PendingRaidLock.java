package com.github.mmo.game.networking.packet.instance;
import com.github.mmo.game.networking.ServerPacket;
public class PendingRaidLock extends ServerPacket
{
	public int timeUntilLock;
	public int completedMask;
	public boolean extending;
	public boolean warningOnly;
	public PendingRaidLock()
	{
		super(ServerOpcode.PendingRaidLock);
	}

	@Override
	public void write()
	{
		this.writeInt32(timeUntilLock);
		this.writeInt32(completedMask);
		this.writeBit(extending);
		this.writeBit(warningOnly);
		this.flushBits();
	}
}
