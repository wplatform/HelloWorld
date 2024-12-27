package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.WorldPacket;

import java.util.ArrayList;


public class QueryQuestItemUsability extends ClientPacket
{
	public ObjectGuid creatureGUID = ObjectGuid.EMPTY;
	public ArrayList<ObjectGuid> itemGUIDs = new ArrayList<>();

	public QueryQuestItemUsability(WorldPacket worldPacket)
	{
		super(worldPacket);
	}

	@Override
	public void read()
	{
		creatureGUID = this.readPackedGuid();
		var itemGuidCount = this.readUInt();

		for (var i = 0; i < itemGuidCount; ++i)
		{
			itemGUIDs.add(this.readPackedGuid());
		}
	}
}
