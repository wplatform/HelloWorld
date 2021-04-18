package com.rainbowland.enums;

public enum CorpseDynFlags {
    CORPSE_DYNFLAG_LOOTABLE(0x0001);
    private final int value;

    CorpseDynFlags(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
