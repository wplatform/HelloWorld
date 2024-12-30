package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.WorldPacket;

public class SpellChargeEntry {

    public int category;

    public int nextRecoveryTime;
    public float chargeModRate = 1.0f;

    public byte consumedCharges;

    public final void write(WorldPacket data) {
        data.writeInt32(category);
        data.writeInt32(nextRecoveryTime);
        data.writeFloat(chargeModRate);
        data.writeInt8(consumedCharges);
    }
}
