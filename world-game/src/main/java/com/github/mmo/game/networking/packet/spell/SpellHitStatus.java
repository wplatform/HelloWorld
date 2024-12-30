package com.github.mmo.game.networking.packet.spell;


import com.github.mmo.game.networking.WorldPacket;

public final class SpellHitStatus {
    public SpellMissInfo reason = SpellMissInfo.values()[0];

    public SpellHitStatus() {
    }

    public SpellHitStatus(SpellMissInfo reason) {
        reason = reason;
    }

    public void write(WorldPacket data) {
        data.writeInt8((byte) reason.getValue());
    }

    public SpellHitStatus clone() {
        SpellHitStatus varCopy = new SpellHitStatus();

        varCopy.reason = this.reason;

        return varCopy;
    }
}
