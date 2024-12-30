package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.networking.ServerPacket;

public class SuspendToken extends ServerPacket {
    public int sequenceIndex = 1;
    public int reason = 1;

    public SuspendToken() {
        super(ServerOpcode.SuspendToken, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(sequenceIndex);
        this.writeBits(reason, 2);
        this.flushBits();
    }
}
