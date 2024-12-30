package com.github.mmo.game.entity;

import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.WorldPacket;

public class SpellCastVisualField {
    public int spellXSpellVisualID;
    public int scriptVisualID;

    public final void writeCreate(WorldPacket data, WorldObject owner, Player receiver) {
        data.writeInt32(spellXSpellVisualID);
        data.writeInt32(scriptVisualID);
    }

    public final void writeUpdate(WorldPacket data, boolean ignoreChangesMask, WorldObject owner, Player receiver) {
        data.writeInt32(spellXSpellVisualID);
        data.writeInt32(scriptVisualID);
    }
}
