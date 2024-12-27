package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.*;
import java.util.*;


class QuestGiverStatusTrackedQuery extends ClientPacket
{
	public ArrayList<ObjectGuid> questGiverGUIDs = new ArrayList<>();

	public QuestGiverStatusTrackedQuery(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		var guidCount = this.readUInt();

		for (int i = 0; i < guidCount; ++i)
		{
			questGiverGUIDs.add(this.readPackedGuid());
		}
	}
}
