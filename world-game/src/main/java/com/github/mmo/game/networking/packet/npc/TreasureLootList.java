package com.github.mmo.game.networking.packet.npc;

import com.github.mmo.game.networking.*;
import java.util.*;


public class TreasureLootList
{
	public ArrayList<TreasureItem> items = new ArrayList<>();

	public final void write(WorldPacket data)
	{
        data.writeInt32(items.size());

		for (var treasureItem : items)
		{
			treasureItem.write(data);
		}
	}
}
