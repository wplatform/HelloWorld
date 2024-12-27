package com.github.mmo.game.networking.packet.quest;
import com.github.mmo.game.networking.ServerPacket;
public class QuestGiverQuestFailed extends ServerPacket
{
	public int questID;
	public InventoryResult reason = InventoryResult.values()[0];
	public QuestGiverQuestFailed()
	{
		super(ServerOpcode.QuestGiverQuestFailed);
	}

	@Override
	public void write()
	{
		this.writeInt32(questID);
		this.writeInt32((int)reason.getValue());
	}
}
