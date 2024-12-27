package com.github.mmo.game.networking.packet.garrison;

import com.github.mmo.game.networking.*;
final class FollowerSoftCapInfo
{
	public void write(WorldPacket data)
	{
        data.writeInt32(garrFollowerTypeID);
        data.writeInt32(count);
	}

	public int garrFollowerTypeID;
	public int count;

	public FollowerSoftCapInfo clone()
	{
		FollowerSoftCapInfo varCopy = new FollowerSoftCapInfo();

		varCopy.garrFollowerTypeID = this.garrFollowerTypeID;
		varCopy.count = this.count;

		return varCopy;
	}
}
