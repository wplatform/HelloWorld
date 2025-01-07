package com.github.azeroth.game.networking.packet.spell;

import com.github.azeroth.game.networking.WorldPacket;

public final class AuraInfo {
    public byte slot;
    public auraDataInfo auraData;

    public void write(WorldPacket data) {
        data.writeInt8(slot);
        data.writeBit(auraData != null);
        data.flushBits();

        if (auraData != null) {
            auraData.write(data);
        }
    }

    public AuraInfo clone() {
        AuraInfo varCopy = new AuraInfo();

        varCopy.slot = this.slot;
        varCopy.auraData = this.auraData;

        return varCopy;
    }
}
