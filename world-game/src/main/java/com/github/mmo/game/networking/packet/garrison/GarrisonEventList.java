package com.github.mmo.game.networking.packet.garrison;

import com.github.mmo.game.networking.*;
import java.util.*;


class GarrisonEventList
{
	public int type;
	public ArrayList<GarrisonEventEntry> events = new ArrayList<>();

	public final void write(WorldPacket data)
	{
		data.writeInt32(type);
		data.writeInt32(events.size());

		for (var eventEntry : events)
		{
			eventEntry.write(data);
		}
	}
}