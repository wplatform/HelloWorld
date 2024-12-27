package com.github.mmo.game.networking.packet.calendar;

import com.github.mmo.game.networking.*;

class CalendarRemoveInvite extends ClientPacket
{
	public ObjectGuid guid = ObjectGuid.EMPTY;
	public long eventID;
	public long moderatorID;
	public long inviteID;
	public CalendarRemoveInvite(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		guid = this.readPackedGuid();
		inviteID = this.readUInt64();
		moderatorID = this.readUInt64();
		eventID = this.readUInt64();
	}
}
