package com.github.azeroth.game.entity;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.networking.WorldPacket;

public class UnitChannel {
    public int spellID;
    public int spellXSpellVisualID;
    public spellCastVisualField spellVisual = new spellCastVisualField();

    public final void writeCreate(WorldPacket data, Unit owner, Player receiver) {
        data.writeInt32(spellID);
        spellVisual.writeCreate(data, owner, receiver);
    }

    public final void writeUpdate(WorldPacket data, boolean ignoreChangesMask, Unit owner, Player receiver) {
        data.writeInt32(spellID);
        spellVisual.writeUpdate(data, ignoreChangesMask, owner, receiver);
    }
}
