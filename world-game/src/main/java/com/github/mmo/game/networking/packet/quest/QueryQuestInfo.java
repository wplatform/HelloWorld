package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.*;

public class QueryQuestInfo extends ClientPacket
{
	public ObjectGuid questGiver = ObjectGuid.EMPTY;
	public int questID;
	public QueryQuestInfo(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		questID = this.readUInt();
		questGiver = this.readPackedGuid();
	}
}
