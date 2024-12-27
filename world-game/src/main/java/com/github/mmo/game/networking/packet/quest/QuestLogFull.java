package com.github.mmo.game.networking.packet.quest;
import com.github.mmo.game.networking.ServerPacket;
public class QuestLogFull extends ServerPacket
{
	public QuestLogFull()
	{
		super(ServerOpcode.QuestLogFull);
	}

	@Override
	public void write()
	{
	}
}
