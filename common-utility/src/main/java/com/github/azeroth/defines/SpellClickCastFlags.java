package com.github.azeroth.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SpellClickCastFlags {
    NPC_CLICK_CAST_CASTER_CLICKER(0x01),
    NPC_CLICK_CAST_TARGET_CLICKER(0x02),
    NPC_CLICK_CAST_ORIG_CASTER_OWNER(0x04);

    public final int value;
}
