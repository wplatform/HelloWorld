package com.github.mmo.game.entity.creature;

public enum ObjectCellMoveState {
    NONE, // not in move list
    active, // in move list
    inactive; // in move list but should not move

    public static final int SIZE = Integer.SIZE;

    public static ObjectCellMoveState forValue(int value) {
        return values()[value];
    }

    public int getValue() {
        return this.ordinal();
    }
}
