package com.github.mmo.game.networking.packet.quest;


import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.networking.ServerPacket;
import com.github.mmo.game.networking.opcode.ServerOpCode;
import com.github.mmo.game.quest.enums.QuestPushReason;

class
QuestPushResultResponse extends ServerPacket {
    public ObjectGuid senderGUID = ObjectGuid.EMPTY;
    public QuestPushReason result = QuestPushReason.values()[0];
    public String questTitle;

    public QuestPushResultResponse() {
        super(ServerOpCode.SMSG_QUEST_PUSH_RESULT);
    }

    @Override
    public void write() {
        this.writeGuid(senderGUID);
        this.writeInt8((byte) result.getValue());

        this.writeBits(questTitle.getBytes().length, 9);
        this.flushBits();

        this.writeString(questTitle);
    }
}
