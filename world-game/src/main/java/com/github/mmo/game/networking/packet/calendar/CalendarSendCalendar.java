package com.github.mmo.game.networking.packet.calendar;


import java.util.*;
import com.github.mmo.game.networking.ServerPacket;
public class CalendarSendCalendar extends ServerPacket
{
	public long serverTime;
	public ArrayList<CalendarSendCalendarInviteInfo> invites = new ArrayList<>();
	public ArrayList<CalendarSendCalendarRaidLockoutInfo> raidLockouts = new ArrayList<>();
	public ArrayList<CalendarSendCalendarEventInfo> events = new ArrayList<>();
	public CalendarSendCalendar()
	{
		super(ServerOpcode.CalendarSendCalendar);
	}

	@Override
	public void write()
	{
		this.writePackedTime(serverTime);
		this.writeInt32(invites.size());
		this.writeInt32(events.size());
		this.writeInt32(raidLockouts.size());

		for (var invite : invites)
		{
			invite.write(this);
		}

		for (var lockout : raidLockouts)
		{
			lockout.write(this);
		}

		for (var Event : events)
		{
			event.write(this);
		}
	}
}
