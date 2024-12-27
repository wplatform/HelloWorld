package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.*;

public class QuestGiverStatusQuery extends ClientPacket
{
	public ObjectGuid questGiverGUID = ObjectGuid.EMPTY;
	public QuestGiverStatusQuery(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		questGiverGUID = this.readPackedGuid();
	}
}

//Structs

