package com.github.azeroth.game.entity;

public interface IUpdateField<T> {
    T getValue();

    void setValue(T value);
}
