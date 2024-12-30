package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.ServerPacket;
import com.github.mmo.game.networking.opcode.ServerOpCode;
import com.github.mmo.game.quest.enums.QuestFailedReason;

public class QuestGiverInvalidQuest extends ServerPacket {
    public QuestFailedReason reason = QuestFailedReason.NONE;
    public int contributionRewardID;
    public boolean sendErrorMessage;
    public String reasonText = "";

    public QuestGiverInvalidQuest() {
        super(ServerOpCode.SMSG_QUEST_GIVER_INVALID_QUEST);
    }

    @Override
    public void write() {
        this.writeInt32((int) reason.value);
        this.writeInt32(contributionRewardID);

        this.writeBit(sendErrorMessage);
        this.writeBits(reasonText.getBytes().length, 9);
        this.flushBits();

        this.writeString(reasonText);
    }
}
