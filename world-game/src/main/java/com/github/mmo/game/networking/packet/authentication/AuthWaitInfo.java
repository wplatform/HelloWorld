package com.github.mmo.game.networking.packet.authentication;

import com.github.mmo.game.networking.*;
public final class AuthWaitInfo
{
	public void write(WorldPacket data)
	{
        data.writeInt32(waitCount);
        data.writeInt32(waitTime);
        data.writeBit(hasFCM);
        data.flushBits();
	}

	public int waitCount; // position of the account in the login queue
	public int waitTime; // Wait time in login queue in minutes, if sent queued and this value is 0 client displays "unknown time"
	public boolean hasFCM; // true if the account has a forced character migration pending. @todo implement

	public AuthWaitInfo clone()
	{
		AuthWaitInfo varCopy = new authWaitInfo();

		varCopy.waitCount = this.waitCount;
		varCopy.waitTime = this.waitTime;
		varCopy.hasFCM = this.hasFCM;

		return varCopy;
	}
}