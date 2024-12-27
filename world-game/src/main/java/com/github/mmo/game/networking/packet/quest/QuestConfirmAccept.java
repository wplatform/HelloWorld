package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.*;
class QuestConfirmAccept extends ClientPacket
{
	public int questID;
	public QuestConfirmAccept(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		questID = this.readUInt();
	}
}
