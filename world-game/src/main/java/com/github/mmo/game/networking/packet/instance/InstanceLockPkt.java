package com.github.mmo.game.networking.packet.instance;

import com.github.mmo.game.networking.*;
public final class InstanceLockPkt
{
	public void write(WorldPacket data)
	{
		data.writeInt32(mapID);
		data.writeInt32(difficultyID);
		data.writeInt64(instanceID);
		data.writeInt32(timeRemaining);
		data.writeInt32(completedMask);

		data.writeBit(locked);
		data.writeBit(extended);
		data.flushBits();
	}

	public long instanceID;
	public int mapID;
	public int difficultyID;
	public int timeRemaining;
	public int completedMask;

	public boolean locked;
	public boolean extended;

	public InstanceLockPkt clone()
	{
		InstanceLockPkt varCopy = new InstanceLockPkt();

		varCopy.instanceID = this.instanceID;
		varCopy.mapID = this.mapID;
		varCopy.difficultyID = this.difficultyID;
		varCopy.timeRemaining = this.timeRemaining;
		varCopy.completedMask = this.completedMask;
		varCopy.locked = this.locked;
		varCopy.extended = this.extended;

		return varCopy;
	}
}
