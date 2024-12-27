package com.github.mmo.game.networking.packet.quest;


import com.github.mmo.game.networking.*;class QuestPushResultResponse extends ServerPacket {
    public ObjectGuid senderGUID = ObjectGuid.EMPTY;
    public QuestPushReason result = QuestPushReason.values()[0];
    public String questTitle;

    public QuestPushResultResponse() {
        super(ServerOpcode.QuestPushResult);
    }

    @Override
    public void write() {
        this.writeGuid(senderGUID);
        this.writeInt8((byte) result.getValue());

        this.writeBits(questTitle.GetByteCount(), 9);
        this.flushBits();

        this.writeString(questTitle);
    }
}
