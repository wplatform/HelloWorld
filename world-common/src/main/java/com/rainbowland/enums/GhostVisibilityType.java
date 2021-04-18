package com.rainbowland.enums;

public enum GhostVisibilityType {
    GHOST_VISIBILITY_ALIVE(0x1),
    GHOST_VISIBILITY_GHOST(0x2);
    private final int value;

    GhostVisibilityType(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
