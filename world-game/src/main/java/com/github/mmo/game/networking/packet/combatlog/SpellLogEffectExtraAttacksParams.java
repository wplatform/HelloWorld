package com.github.mmo.game.networking.packet.combatlog;

import com.github.mmo.game.entity.object.ObjectGuid;

public final class SpellLogEffectExtraAttacksParams {
    public ObjectGuid victim = ObjectGuid.EMPTY;

    public int numAttacks;

}
