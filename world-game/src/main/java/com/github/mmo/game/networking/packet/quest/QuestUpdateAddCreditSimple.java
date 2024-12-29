package com.github.mmo.game.networking.packet.quest;


import com.github.mmo.game.networking.*;
import com.github.mmo.game.networking.opcode.ServerOpCode;
import com.github.mmo.game.quest.enums.QuestObjectiveType;

class QuestUpdateAddCreditSimple extends ServerPacket {

    public int questID;
    public int objectID;
    public QuestObjectiveType objectiveType = QuestObjectiveType.values()[0];

    public QuestUpdateAddCreditSimple() {
        super(ServerOpCode.SMSG_QUEST_UPDATE_ADD_CREDIT_SIMPLE);
    }

    @Override
    public void write() {
        this.writeInt32(questID);
        this.writeInt32(objectID);
        this.writeInt8(objectiveType.ordinal());
    }
}
