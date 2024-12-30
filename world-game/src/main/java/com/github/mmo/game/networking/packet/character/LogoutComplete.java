package com.github.mmo.game.networking.packet.character;


public class LogoutComplete extends ServerPacket {
    public LogoutComplete() {
        super(ServerOpcode.LogoutComplete);
    }

    @Override
    public void write() {
    }
}
