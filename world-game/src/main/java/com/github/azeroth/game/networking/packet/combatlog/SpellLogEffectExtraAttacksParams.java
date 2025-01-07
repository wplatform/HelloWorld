package com.github.azeroth.game.networking.packet.combatlog;

import com.github.azeroth.game.entity.object.ObjectGuid;

public final class SpellLogEffectExtraAttacksParams {
    public ObjectGuid victim = ObjectGuid.EMPTY;

    public int numAttacks;

}
