package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.*;

public class QuestGiverHello extends ClientPacket
{
	public ObjectGuid questGiverGUID = ObjectGuid.EMPTY;
	public QuestGiverHello(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		questGiverGUID = this.readPackedGuid();
	}
}
