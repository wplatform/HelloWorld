package com.rainbowland.enums;

public enum CharacterCustomizeFlags {
    CHAR_CUSTOMIZE_FLAG_NONE(0x00000000),
    CHAR_CUSTOMIZE_FLAG_CUSTOMIZE(0x00000001), // name, gender, etc...
    CHAR_CUSTOMIZE_FLAG_FACTION(0x00010000), // name, gender, faction, etc...
    CHAR_CUSTOMIZE_FLAG_RACE(0x00100000);  // name, gender, race, etc...
    private final int value;

    CharacterCustomizeFlags(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
