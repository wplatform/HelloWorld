package com.github.mmo.game.networking.packet.scene;

import com.github.mmo.game.networking.WorldPacket;

class ScenePlaybackComplete extends ClientPacket {
    public int sceneInstanceID;

    public ScenePlaybackComplete(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        sceneInstanceID = this.readUInt();
    }
}
