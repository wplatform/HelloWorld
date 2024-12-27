package com.github.mmo.game.networking.packet.system;

import com.github.mmo.game.networking.*;
public final class SavedThrottleObjectState
{
	public int maxTries;
	public int perMilliseconds;
	public int tryCount;
	public int lastResetTimeBeforeNow;

	public void write(WorldPacket data)
	{
		data.writeInt32(maxTries);
		data.writeInt32(perMilliseconds);
		data.writeInt32(tryCount);
		data.writeInt32(lastResetTimeBeforeNow);
	}

	public SavedThrottleObjectState clone()
	{
		SavedThrottleObjectState varCopy = new savedThrottleObjectState();

		varCopy.maxTries = this.maxTries;
		varCopy.perMilliseconds = this.perMilliseconds;
		varCopy.tryCount = this.tryCount;
		varCopy.lastResetTimeBeforeNow = this.lastResetTimeBeforeNow;

		return varCopy;
	}
}
