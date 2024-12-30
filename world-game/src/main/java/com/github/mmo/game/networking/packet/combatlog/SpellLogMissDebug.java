package com.github.mmo.game.networking.packet.combatlog;

import com.github.mmo.game.networking.WorldPacket;

final class SpellLogMissDebug {
    public float hitRoll;
    public float hitRollNeeded;

    public void write(WorldPacket data) {
        data.writeFloat(hitRoll);
        data.writeFloat(hitRollNeeded);
    }

    public SpellLogMissDebug clone() {
        SpellLogMissDebug varCopy = new SpellLogMissDebug();

        varCopy.hitRoll = this.hitRoll;
        varCopy.hitRollNeeded = this.hitRollNeeded;

        return varCopy;
    }
}
