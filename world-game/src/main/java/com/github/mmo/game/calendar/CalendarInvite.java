package com.github.mmo.game.calendar;


public class CalendarInvite
{
	private long inviteId;
	public final long getInviteId()
	{
		return inviteId;
	}
	public final void setInviteId(long value)
	{
		inviteId = value;
	}
	private long eventId;
	public final long getEventId()
	{
		return eventId;
	}
	public final void setEventId(long value)
	{
		eventId = value;
	}
	private ObjectGuid inviteeGuid = ObjectGuid.EMPTY;
	public final ObjectGuid getInviteeGuid()
	{
		return inviteeGuid;
	}
	public final void setInviteeGuid(ObjectGuid value)
	{
		inviteeGuid = value;
	}
	private ObjectGuid senderGuid = ObjectGuid.EMPTY;
	public final ObjectGuid getSenderGuid()
	{
		return senderGuid;
	}
	public final void setSenderGuid(ObjectGuid value)
	{
		senderGuid = value;
	}
	private long responseTime;
	public final long getResponseTime()
	{
		return responseTime;
	}
	public final void setResponseTime(long value)
	{
		responseTime = value;
	}
	private CalendarInvitestatus status = CalendarInviteStatus.values()[0];
	public final CalendarInviteStatus getStatus()
	{
		return status;
	}
	public final void setStatus(CalendarInviteStatus value)
	{
		status = value;
	}
	private CalendarModerationrank rank = CalendarModerationRank.values()[0];
	public final CalendarModerationRank getRank()
	{
		return rank;
	}
	public final void setRank(CalendarModerationRank value)
	{
		rank = value;
	}
	private String note;
	public final String getNote()
	{
		return note;
	}
	public final void setNote(String value)
	{
		note = value;
	}

	public CalendarInvite()
	{
		setInviteId(1);
		setResponseTime(0);
		setStatus(CalendarInviteStatus.Invited);
		setRank(CalendarModerationRank.player);
		setNote("");
	}

	public CalendarInvite(CalendarInvite calendarInvite, long inviteId, long eventId)
	{
		setInviteId(inviteId);
		setEventId(eventId);
		setInviteeGuid(calendarInvite.getInviteeGuid());
		setSenderGuid(calendarInvite.getSenderGuid());
		setResponseTime(calendarInvite.getResponseTime());
		setStatus(calendarInvite.getStatus());
		setRank(calendarInvite.getRank());
		setNote(calendarInvite.getNote());
	}

	public CalendarInvite(long inviteId, long eventId, ObjectGuid invitee, ObjectGuid senderGUID, long responseTime, CalendarInviteStatus status, CalendarModerationRank rank, String note)
	{
		setInviteId(inviteId);
		setEventId(eventId);
		setInviteeGuid(invitee);
		setSenderGuid(senderGUID);
		setResponseTime(responseTime);

		setStatus(status);
		setRank(rank);
		setNote(note);
	}

	protected void finalize() throws Throwable
	{
		if (getInviteId() != 0 && getEventId() != 0)
		{
			global.getCalendarMgr().freeInviteId(getInviteId());
		}
	}
}
