package com.rainbowland.enums;

// loot modes for creatures and gameobjects, bitmask!
public enum LootModes {
    LOOT_MODE_DEFAULT(0x1),
    LOOT_MODE_HARD_MODE_1(0x2),
    LOOT_MODE_HARD_MODE_2(0x4),
    LOOT_MODE_HARD_MODE_3(0x8),
    LOOT_MODE_HARD_MODE_4(0x10),
    LOOT_MODE_JUNK_FISH(0x8000);


    private final int value;

    LootModes(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }

}

