package com.github.mmo.game.map.enums;

public enum LoadResult {
    Success,
    FileNotFound,
    VersionMismatch,
    ReadFromFileFailed,
    DisabledInConfig;

    public static final int SIZE = Integer.SIZE;

    public static LoadResult forValue(int value) {
        return values()[value];
    }

    public int getValue() {
        return this.ordinal();
    }
}
