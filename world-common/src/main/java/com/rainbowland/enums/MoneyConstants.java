package com.rainbowland.enums;

public enum MoneyConstants {
    COPPER(1),
    SILVER(COPPER.val() * 100),
    GOLD(SILVER.val() * 100);

    private final int value;

    MoneyConstants(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
