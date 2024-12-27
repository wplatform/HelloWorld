package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.*;class RequestWorldQuestUpdate extends ClientPacket {
    public RequestWorldQuestUpdate(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
