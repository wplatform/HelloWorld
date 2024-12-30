package com.github.mmo.game.networking.packet.duel;


public class DuelOutOfBounds extends ServerPacket {
    public DuelOutOfBounds() {
        super(ServerOpcode.DuelOutOfBounds, ConnectionType.instance);
    }

    @Override
    public void write() {
    }
}
