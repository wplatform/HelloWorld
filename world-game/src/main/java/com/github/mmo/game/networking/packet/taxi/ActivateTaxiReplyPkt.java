package com.github.mmo.game.networking.packet.taxi;

import com.github.mmo.game.networking.ServerPacket;

public class ActivateTaxiReplyPkt extends ServerPacket {
    public ActivateTaxireply reply = ActivateTaxiReply.values()[0];

    public ActivateTaxiReplyPkt() {
        super(ServerOpcode.ActivateTaxiReply);
    }

    @Override
    public void write() {
        this.writeBits(reply, 4);
        this.flushBits();
    }
}
