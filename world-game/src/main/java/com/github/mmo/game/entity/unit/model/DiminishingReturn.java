package com.github.mmo.game.entity.unit.model;

public class DiminishingReturn {

    short stack;
    int hitTime;
    int hitCount;

    void clear() {
        stack = 0;
        hitTime = 0;
        hitCount = 0;
    }
}
