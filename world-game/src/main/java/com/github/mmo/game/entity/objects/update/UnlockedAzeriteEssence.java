package com.github.mmo.game.entity;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.WorldPacket;

public class UnlockedAzeriteEssence {

    public int azeriteEssenceID;

    public int rank;

    public final void writeCreate(WorldPacket data, AzeriteItem owner, Player receiver) {
        data.writeInt32(azeriteEssenceID);
        data.writeInt32(rank);
    }

    public final void writeUpdate(WorldPacket data, boolean ignoreChangesMask, AzeriteItem owner, Player receiver) {
        data.writeInt32(azeriteEssenceID);
        data.writeInt32(rank);
    }
}
