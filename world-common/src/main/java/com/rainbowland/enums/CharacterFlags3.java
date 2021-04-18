package com.rainbowland.enums;

public enum CharacterFlags3 {
    CHARACTER_FLAG_3_LOCKED_BY_REVOKED_VAS_TRANSACTION(0x00100000),
    CHARACTER_FLAG_3_LOCKED_BY_REVOKED_CHARACTER_UPGRADE(0x80000000);
    private final int value;

    CharacterFlags3(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
