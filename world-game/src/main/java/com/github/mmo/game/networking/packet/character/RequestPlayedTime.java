package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.networking.WorldPacket;

public class RequestPlayedTime extends ClientPacket {
    public boolean triggerScriptEvent;

    public RequestPlayedTime(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        triggerScriptEvent = this.readBit();
    }
}
