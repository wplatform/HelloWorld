package com.github.mmo.game.networking.packet.duel;


public class DuelComplete extends ServerPacket {
    public boolean started;

    public duelComplete() {
        super(ServerOpcode.DuelComplete, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeBit(started);
        this.flushBits();
    }
}
