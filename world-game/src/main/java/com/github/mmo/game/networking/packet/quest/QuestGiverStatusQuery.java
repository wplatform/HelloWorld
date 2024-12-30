package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class QuestGiverStatusQuery extends ClientPacket {
    public ObjectGuid questGiverGUID = ObjectGuid.EMPTY;

    public QuestGiverStatusQuery(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        questGiverGUID = this.readPackedGuid();
    }
}

//Structs

