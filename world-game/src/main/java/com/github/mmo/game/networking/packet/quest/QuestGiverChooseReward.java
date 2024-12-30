package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class QuestGiverChooseReward extends ClientPacket {
    public ObjectGuid questGiverGUID = ObjectGuid.EMPTY;
    public int questID;
    public QuestChoiceItem choice = new QuestChoiceItem();

    public QuestGiverChooseReward(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        questGiverGUID = this.readPackedGuid();
        questID = this.readUInt();
        choice.read(this);
    }
}
