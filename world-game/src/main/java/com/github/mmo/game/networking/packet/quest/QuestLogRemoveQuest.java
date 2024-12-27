package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.*;
public class QuestLogRemoveQuest extends ClientPacket
{
	public byte entry;
	public QuestLogRemoveQuest(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        entry = this.readUInt8();
	}
}
