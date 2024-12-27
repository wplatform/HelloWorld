package com.github.mmo.game.networking.packet.calendar;

import com.github.mmo.game.networking.*;
class CalendarGetEvent extends ClientPacket
{
	public long eventID;
	public CalendarGetEvent(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		eventID = this.readUInt64();
	}
}
