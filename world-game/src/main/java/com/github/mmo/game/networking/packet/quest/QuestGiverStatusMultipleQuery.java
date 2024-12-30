package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class QuestGiverStatusMultipleQuery extends ClientPacket {
    public QuestGiverStatusMultipleQuery(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
