package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class RequestWorldQuestUpdate extends ClientPacket {
    public RequestWorldQuestUpdate(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
