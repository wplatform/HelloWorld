package com.github.mmo.game.networking.packet.quest;
import com.github.mmo.game.networking.ServerPacket;
public class QuestUpdateComplete extends ServerPacket
{
	public int questID;
	public QuestUpdateComplete()
	{
		super(ServerOpcode.QuestUpdateComplete);
	}

	@Override
	public void write()
	{
		this.writeInt32(questID);
	}
}
