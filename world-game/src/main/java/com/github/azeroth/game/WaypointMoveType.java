package com.github.azeroth.game;


public enum WaypointMoveType {
    Walk,
    run,
    Land,
    Takeoff,

    max;

    public static final int SIZE = Integer.SIZE;

    public static WaypointMoveType forValue(int value) {
        return values()[value];
    }

    public int getValue() {
        return this.ordinal();
    }
}
