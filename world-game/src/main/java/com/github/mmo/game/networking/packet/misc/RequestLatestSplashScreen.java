package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.*;class RequestLatestSplashScreen extends ClientPacket {
    public RequestLatestSplashScreen(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
