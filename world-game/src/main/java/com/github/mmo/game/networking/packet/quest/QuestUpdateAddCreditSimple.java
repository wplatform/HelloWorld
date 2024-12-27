package com.github.mmo.game.networking.packet.quest;


import com.github.mmo.game.networking.*;class QuestUpdateAddCreditSimple extends ServerPacket {

    public int questID;
    public int objectID;
    public QuestobjectiveType objectiveType = QuestObjectiveType.values()[0];

    public QuestUpdateAddCreditSimple() {
        super(ServerOpcode.QuestUpdateAddCreditSimple, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(questID);
        this.writeInt32(objectID);
        this.writeInt8((byte) objectiveType.getValue());
    }
}
