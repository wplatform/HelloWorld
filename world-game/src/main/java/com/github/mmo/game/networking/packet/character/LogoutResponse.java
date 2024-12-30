package com.github.mmo.game.networking.packet.character;


public class LogoutResponse extends ServerPacket {
    public int logoutResult;
    public boolean instant = false;

    public LogoutResponse() {
        super(ServerOpcode.LogoutResponse, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(logoutResult);
        this.writeBit(instant);
        this.flushBits();
    }
}
