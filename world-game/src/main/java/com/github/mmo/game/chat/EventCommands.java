package com.github.mmo.game.chat;


// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
class EventCommands
{
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	private static boolean handleEventInfoCommand(CommandHandler handler, short eventId)
	{
		var events = global.getGameEventMgr().getEventMap();

		if (eventId >= events.length)
		{
			handler.sendSysMessage(CypherStrings.EventNotExist);

			return false;
		}

		var eventData = events[eventId];

		if (!eventData.isValid())
		{
			handler.sendSysMessage(CypherStrings.EventNotExist);

			return false;
		}

		var activeEvents = global.getGameEventMgr().getActiveEventList();
		var active = activeEvents.contains(eventId);
		var activeStr = active ? global.getObjectMgr().getCypherString(CypherStrings.active) : "";

		var startTimeStr = time.UnixTimeToDateTime(eventData.start).ToLongDateString();
		var endTimeStr = time.UnixTimeToDateTime(eventData.end).ToLongDateString();

		var delay = global.getGameEventMgr().nextCheck(eventId);
		var nextTime = gameTime.GetGameTime() + delay;
		var nextStr = nextTime >= eventData.start && nextTime < eventData.end ? time.UnixTimeToDateTime(gameTime.GetGameTime() + delay).ToShortTimeString() : "-";

		var occurenceStr = time.secsToTimeString(eventData.occurence * time.Minute, 0, false);
		var lengthStr = time.secsToTimeString(eventData.length * time.Minute, 0, false);

		handler.sendSysMessage(CypherStrings.eventInfo, eventId, eventData.description, activeStr, startTimeStr, endTimeStr, occurenceStr);

		return true;
	}

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	private static boolean handleEventActiveListCommand(CommandHandler handler)
	{
		int counter = 0;

		var events = global.getGameEventMgr().getEventMap();
		var activeEvents = global.getGameEventMgr().getActiveEventList();

		var active = global.getObjectMgr().getCypherString(CypherStrings.active);

		for (var eventId : activeEvents)
		{
			var eventData = events[eventId];

			if (handler.getSession() != null)
			{
				handler.sendSysMessage(CypherStrings.EventEntryListChat, eventId, eventId, eventData.description, active);
			}
			else
			{
				handler.sendSysMessage(CypherStrings.EventEntryListConsole, eventId, eventData.description, active);
			}

			++counter;
		}

		if (counter == 0)
		{
			handler.sendSysMessage(CypherStrings.Noeventfound);
		}

		return true;
	}

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	private static boolean handleEventStartCommand(CommandHandler handler, short eventId)
	{
		var events = global.getGameEventMgr().getEventMap();

		if (eventId < 1 || eventId >= events.length)
		{
			handler.sendSysMessage(CypherStrings.EventNotExist);

			return false;
		}

		var eventData = events[eventId];

		if (!eventData.isValid())
		{
			handler.sendSysMessage(CypherStrings.EventNotExist);

			return false;
		}

		var activeEvents = global.getGameEventMgr().getActiveEventList();

		if (activeEvents.contains(eventId))
		{
			handler.sendSysMessage(CypherStrings.EventAlreadyActive, eventId);

			return false;
		}

		global.getGameEventMgr().startEvent(eventId, true);

		return true;
	}

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	private static boolean handleEventStopCommand(CommandHandler handler, short eventId)
	{
		var events = global.getGameEventMgr().getEventMap();

		if (eventId < 1 || eventId >= events.length)
		{
			handler.sendSysMessage(CypherStrings.EventNotExist);

			return false;
		}

		var eventData = events[eventId];

		if (!eventData.isValid())
		{
			handler.sendSysMessage(CypherStrings.EventNotExist);

			return false;
		}

		var activeEvents = global.getGameEventMgr().getActiveEventList();

		if (!activeEvents.contains(eventId))
		{
			handler.sendSysMessage(CypherStrings.EventNotActive, eventId);

			return false;
		}

		global.getGameEventMgr().stopEvent(eventId, true);

		return true;
	}
}
