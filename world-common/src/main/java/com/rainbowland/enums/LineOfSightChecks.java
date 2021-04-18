package com.rainbowland.enums;

public enum LineOfSightChecks {
    LINEOFSIGHT_CHECK_VMAP(0x1), // check static floor layout data
    LINEOFSIGHT_CHECK_GOBJECT(0x2), // check dynamic game object data

    LINEOFSIGHT_ALL_CHECKS(0x1 | 0x2);

    private final int value;

    LineOfSightChecks(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
