package com.github.mmo.game.networking.packet.misc;


public class CorpseReclaimDelay extends ServerPacket {
    public int remaining;

    public CorpseReclaimDelay() {
        super(ServerOpcode.CorpseReclaimDelay, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(remaining);
    }
}
