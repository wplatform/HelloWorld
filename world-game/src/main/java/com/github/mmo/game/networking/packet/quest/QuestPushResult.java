package com.github.mmo.game.networking.packet.quest;


import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;
import com.github.mmo.game.quest.enums.QuestPushReason;

class QuestPushResult extends ClientPacket {
    public ObjectGuid senderGUID = ObjectGuid.EMPTY;
    public int questID;
    public QuestPushReason result = QuestPushReason.Success;

    public QuestPushResult(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        senderGUID = this.readPackedGuid();
        questID = this.readUInt();
        result = QuestPushReason.forValue(this.readUInt8());
    }
}
