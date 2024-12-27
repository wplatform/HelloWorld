package com.github.mmo.game.networking.packet.scene;

import com.github.mmo.game.networking.WorldPacket;

class ScenePlaybackCanceled extends ClientPacket {

    public int sceneInstanceID;

    public ScenePlaybackCanceled(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        sceneInstanceID = this.readUInt();
    }
}
