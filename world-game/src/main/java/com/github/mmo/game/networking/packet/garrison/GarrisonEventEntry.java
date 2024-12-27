package com.github.mmo.game.networking.packet.garrison;

import com.github.mmo.game.networking.*;
final class GarrisonEventEntry
{
	public int entryID;
	public long eventValue;

	public void write(WorldPacket data)
	{
		data.writeInt64(eventValue);
		data.writeInt32(entryID);
	}

	public GarrisonEventEntry clone()
	{
		GarrisonEventEntry varCopy = new GarrisonEventEntry();

		varCopy.entryID = this.entryID;
		varCopy.eventValue = this.eventValue;

		return varCopy;
	}
}
