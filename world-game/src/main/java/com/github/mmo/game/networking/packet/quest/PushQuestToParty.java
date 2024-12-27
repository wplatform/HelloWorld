package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.*;
class PushQuestToParty extends ClientPacket
{
	public int questID;
	public PushQuestToParty(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        questID = this.readUInt();
	}
}
