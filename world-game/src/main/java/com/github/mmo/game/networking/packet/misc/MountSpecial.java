package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class MountSpecial extends ClientPacket {
    public int[] spellVisualKitIDs;
    public int sequenceVariation;

    public MountSpecial(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        spellVisualKitIDs = new int[this.readUInt()];
        sequenceVariation = this.readInt32();

        for (var i = 0; i < spellVisualKitIDs.length; ++i) {
            SpellVisualKitIDs[i] = this.readInt32();
        }
    }
}
