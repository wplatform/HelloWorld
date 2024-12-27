package com.github.mmo.utils;

public interface Flags {

    static boolean hasFlag(int value, int flag) {
        return (value & flag) != 0;
    }

    static boolean hasAllFlags(int value, int flag) {
        return (value & flag) == flag;
    }


}
