package com.github.mmo.game.entity;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.*;public class Research {
    public short researchProjectID;

    public final void writeCreate(WorldPacket data, Player owner, Player receiver) {
        data.writeInt16(researchProjectID);
    }

    public final void writeUpdate(WorldPacket data, boolean ignoreChangesMask, Player owner, Player receiver) {
        data.writeInt16(researchProjectID);
    }
}
