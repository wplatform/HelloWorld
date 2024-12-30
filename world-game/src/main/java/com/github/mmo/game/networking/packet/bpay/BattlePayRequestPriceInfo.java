package com.github.mmo.game.networking.packet.bpay;

import com.github.mmo.game.networking.WorldPacket;

public final class BattlePayRequestPriceInfo extends ClientPacket {
    private byte unkByte = 0;

    public BattlePayRequestPriceInfo(WorldPacket packet) {
        super(packet);
    }

    public byte getUnkByte() {
        return unkByte;
    }

    public void setUnkByte(byte value) {
        unkByte = value;
    }

    @Override
    public void read() {
    }
}
