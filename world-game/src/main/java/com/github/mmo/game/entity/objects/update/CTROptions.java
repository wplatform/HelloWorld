package com.github.mmo.game.entity;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.WorldPacket;

public class CTROptions {

    public int contentTuningConditionMask;

    public int field_4;

    public int expansionLevelMask;

    public final void writeCreate(WorldPacket data, Player owner, Player receiver) {
        data.writeInt32(contentTuningConditionMask);
        data.writeInt32(field_4);
        data.writeInt32(expansionLevelMask);
    }

    public final void writeUpdate(WorldPacket data, boolean ignoreChangesMask, Player owner, Player receiver) {
        data.writeInt32(contentTuningConditionMask);
        data.writeInt32(field_4);
        data.writeInt32(expansionLevelMask);
    }
}
