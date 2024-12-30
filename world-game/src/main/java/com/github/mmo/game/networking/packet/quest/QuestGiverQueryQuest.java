package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class QuestGiverQueryQuest extends ClientPacket {
    public ObjectGuid questGiverGUID = ObjectGuid.EMPTY;
    public int questID;
    public boolean respondToGiver;

    public QuestGiverQueryQuest(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        questGiverGUID = this.readPackedGuid();
        questID = this.readUInt();
        respondToGiver = this.readBit();
    }
}
