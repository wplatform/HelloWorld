package com.github.mmo.game.networking.packet.calendar;

import com.github.mmo.game.networking.*;
final class CalendarSendCalendarRaidLockoutInfo
{
	public void write(WorldPacket data)
	{
		data.writeInt64(instanceID);
		data.writeInt32(mapID);
		data.writeInt32(difficultyID);
		data.writeInt32(expireTime);
	}

	public long instanceID;
	public int mapID;
	public int difficultyID;
	public int expireTime;

	public CalendarSendCalendarRaidLockoutInfo clone()
	{
		CalendarSendCalendarRaidLockoutInfo varCopy = new CalendarSendCalendarRaidLockoutInfo();

		varCopy.instanceID = this.instanceID;
		varCopy.mapID = this.mapID;
		varCopy.difficultyID = this.difficultyID;
		varCopy.expireTime = this.expireTime;

		return varCopy;
	}
}
