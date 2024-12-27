package com.github.mmo.game.networking.packet.quest;
import com.github.mmo.game.networking.ServerPacket;
public class QuestUpdateAddPvPCredit extends ServerPacket
{
	public int questID;
	public short count;
	public QuestUpdateAddPvPCredit()
	{
		super(ServerOpcode.QuestUpdateAddPvpCredit, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeInt32(questID);
		this.writeInt16(count);
	}
}
