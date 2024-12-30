package com.github.mmo.game.networking.packet.scene;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class SceneTriggerEvent extends ClientPacket {
    public int sceneInstanceID;
    public String _Event;

    public SceneTriggerEvent(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        var len = this.<Integer>readBit(6);
        sceneInstanceID = this.readUInt();
        _Event = this.readString(len);
    }
}
