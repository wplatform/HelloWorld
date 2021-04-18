package com.rainbowland.enums;

public enum EventId {
    EVENT_CHARGE(1003),
    EVENT_JUMP(1004),

    /// Special charge event which is used for charge spells that have explicit targets
    /// and had a path already generated - using it in PointMovementGenerator will not
    /// create a new spline and launch it
    EVENT_CHARGE_PREPATH(1005);
    private final int value;

    EventId(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }

}
