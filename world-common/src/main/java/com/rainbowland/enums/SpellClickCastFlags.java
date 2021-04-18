package com.rainbowland.enums;

public enum SpellClickCastFlags {
    NPC_CLICK_CAST_CASTER_CLICKER(0x01),
    NPC_CLICK_CAST_TARGET_CLICKER(0x02),
    NPC_CLICK_CAST_ORIG_CASTER_OWNER(0x04);

    private final int value;

    SpellClickCastFlags(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
