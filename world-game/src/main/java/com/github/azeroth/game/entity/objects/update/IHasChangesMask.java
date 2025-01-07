package com.github.azeroth.game.entity;

public interface IHasChangesMask {
    void clearChangesMask();

    UpdateMask getUpdateMask();
}
