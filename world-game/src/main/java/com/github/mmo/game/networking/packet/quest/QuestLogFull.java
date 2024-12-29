package com.github.mmo.game.networking.packet.quest;
import com.github.mmo.game.networking.ServerPacket;
import com.github.mmo.game.networking.opcode.ServerOpCode;

public class QuestLogFull extends ServerPacket
{
	public QuestLogFull()
	{
		super(ServerOpCode.SMSG_QUEST_LOG_FULL);
	}

	@Override
	public void write()
	{
	}
}
