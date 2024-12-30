package com.github.mmo.game.networking.packet.authentication;

import com.github.mmo.game.networking.ServerPacket;

public class ResumeComms extends ServerPacket {
    public ResumeComms(ConnectionType connection) {
        super(ServerOpcode.ResumeComms, connection);
    }

    @Override
    public void write() {
    }
}
