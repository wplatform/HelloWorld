package com.rainbowland.enums;

public enum CharacterFlags4 {
    CHARACTER_FLAG_4_TRIAL_BOOST(0x00000080),
    CHARACTER_FLAG_4_TRIAL_BOOST_LOCKED(0x00040000),
    CHARACTER_FLAG_4_EXPANSION_TRIAL(0x00080000);
    private final int value;

    CharacterFlags4(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
