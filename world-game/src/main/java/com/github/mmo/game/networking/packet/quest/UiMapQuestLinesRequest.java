package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.WorldPacket;

public class UiMapQuestLinesRequest extends ClientPacket {
    public int uiMapID;

    public UiMapQuestLinesRequest(WorldPacket worldPacket) {
        super(worldPacket);
    }

    @Override
    public void read() {
        uiMapID = this.readInt32();
    }
}
