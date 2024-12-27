package com.github.mmo.game.networking.packet.quest;
import com.github.mmo.game.networking.ServerPacket;
public class QuestGiverInvalidQuest extends ServerPacket
{
	public QuestFailedreasons reason = QuestFailedReasons.values()[0];
	public int contributionRewardID;
	public boolean sendErrorMessage;
	public String reasonText = "";
	public QuestGiverInvalidQuest()
	{
		super(ServerOpcode.QuestGiverInvalidQuest);
	}

	@Override
	public void write()
	{
		this.writeInt32((int)reason.getValue());
		this.writeInt32(contributionRewardID);

		this.writeBit(sendErrorMessage);
		this.writeBits(reasonText.GetByteCount(), 9);
		this.flushBits();

		this.writeString(reasonText);
	}
}
