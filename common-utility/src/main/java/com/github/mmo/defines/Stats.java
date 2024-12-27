package com.github.mmo.defines;

public enum Stats {
    STAT_STRENGTH(0), STAT_AGILITY(1), STAT_STAMINA(2), STAT_INTELLECT(3);

    public final int value;

    Stats(int value) {
        this.value = value;
    }
}
