package com.github.mmo.game.networking.packet.instance;

import com.github.mmo.game.networking.ServerPacket;

public class ResetFailedNotify extends ServerPacket {
    public ResetFailedNotify() {
        super(ServerOpcode.ResetFailedNotify);
    }

    @Override
    public void write() {
    }
}
