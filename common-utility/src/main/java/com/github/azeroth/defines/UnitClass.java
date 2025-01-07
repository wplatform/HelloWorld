package com.github.azeroth.defines;

public enum UnitClass {
    UNIT_CLASS_WARRIOR(1), UNIT_CLASS_PALADIN(2), UNIT_CLASS_ROGUE(4), UNIT_CLASS_MAGE(8);

    private final int value;

    UnitClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
