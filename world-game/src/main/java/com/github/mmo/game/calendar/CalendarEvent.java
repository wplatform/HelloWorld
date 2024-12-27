package com.github.mmo.game.calendar;


import com.github.mmo.game.entity.object.ObjectGuid;

public class CalendarEvent
{
	private long eventId;
	public final long getEventId()
	{
		return eventId;
	}
	public final void setEventId(long value)
	{
		eventId = value;
	}
	private ObjectGuid ownerGuid = ObjectGuid.EMPTY;
	public final ObjectGuid getOwnerGuid()
	{
		return ownerGuid;
	}
	public final void setOwnerGuid(ObjectGuid value)
	{
		ownerGuid = value;
	}
	private long guildId;
	public final long getGuildId()
	{
		return guildId;
	}
	public final void setGuildId(long value)
	{
		guildId = value;
	}
	private CalendareventType eventType = CalendarEventType.values()[0];
	public final CalendarEventType getEventType()
	{
		return eventType;
	}
	public final void setEventType(CalendarEventType value)
	{
		eventType = value;
	}
	private int textureId;
	public final int getTextureId()
	{
		return textureId;
	}
	public final void setTextureId(int value)
	{
		textureId = value;
	}
	private long date;
	public final long getDate()
	{
		return date;
	}
	public final void setDate(long value)
	{
		date = value;
	}
	private Calendarflags flags = CalendarFlags.values()[0];
	public final CalendarFlags getFlags()
	{
		return flags;
	}
	public final void setFlags(CalendarFlags value)
	{
		flags = value;
	}
	private String title;
	public final String getTitle()
	{
		return title;
	}
	public final void setTitle(String value)
	{
		title = value;
	}
	private String description;
	public final String getDescription()
	{
		return description;
	}
	public final void setDescription(String value)
	{
		description = value;
	}
	private long lockDate;
	public final long getLockDate()
	{
		return lockDate;
	}
	public final void setLockDate(long value)
	{
		lockDate = value;
	}

	public final boolean isGuildEvent()
	{
		return getFlags().HasAnyFlag(CalendarFlags.GuildEvent);
	}
	public final boolean isGuildAnnouncement()
	{
		return getFlags().HasAnyFlag(CalendarFlags.WithoutInvites);
	}
	public final boolean isLocked()
	{
		return getFlags().HasAnyFlag(CalendarFlags.InvitesLocked);
	}

	public CalendarEvent(CalendarEvent calendarEvent, long eventId)
	{
		setEventId(eventId);
		setOwnerGuid(calendarEvent.getOwnerGuid());
		setGuildId(calendarEvent.getGuildId());
		setEventType(calendarEvent.getEventType());
		setTextureId(calendarEvent.getTextureId());
		setDate(calendarEvent.getDate());
		setFlags(calendarEvent.getFlags());
		setLockDate(calendarEvent.getLockDate());
		setTitle(calendarEvent.getTitle());
		setDescription(calendarEvent.getDescription());
	}

	public CalendarEvent(long eventId, ObjectGuid ownerGuid, long guildId, CalendarEventType type, int textureId, long date, CalendarFlags flags, String title, String description, long lockDate)
	{
		setEventId(eventId);
		setOwnerGuid(ownerGuid);
		setGuildId(guildId);
		setEventType(type);
		setTextureId(textureId);
		setDate(date);
		setFlags(flags);
		setLockDate(lockDate);
		setTitle(title);
		setDescription(description);
	}

	public CalendarEvent()
	{
		setEventId(1);
		setEventType(CalendarEventType.other);
		setTextureId(-1);
		setTitle("");
		setDescription("");
	}

	public final String buildCalendarMailSubject(ObjectGuid remover)
	{
		return remover + ":" + getTitle();
	}

	public final String buildCalendarMailBody()
	{
		var now = time.UnixTimeToDateTime(getDate());
		var time = (int)(((now.getYear() - 1900) - 100) << 24 | (now.getMonthValue() - 1) << 20 | (now.getDayOfMonth() - 1) << 14 | now.getDayOfWeek().getValue() << 11 | now.getHour() << 6 | now.getMinute());

		return String.valueOf(time);
	}

	public static boolean modifyIsGuildEventFlags(int flags)
	{
		return (flags & (int)CalendarFlags.GuildEvent.getValue()) != 0;
	}

	public static boolean modifyIsGuildAnnouncementFlags(int flags)
	{
		return (flags & (int)CalendarFlags.WithoutInvites.getValue()) != 0;
	}
}
