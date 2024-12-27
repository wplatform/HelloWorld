package com.github.mmo.game.networking.packet.quest;
import com.github.mmo.game.networking.ServerPacket;
public class QuestUpdateFailedTimer extends ServerPacket
{
	public int questID;
	public QuestUpdateFailedTimer()
	{
		super(ServerOpcode.QuestUpdateFailedTimer);
	}

	@Override
	public void write()
	{
        this.writeInt32(questID);
	}
}
