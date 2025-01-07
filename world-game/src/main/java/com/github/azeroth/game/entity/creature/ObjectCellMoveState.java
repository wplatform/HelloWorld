package com.github.azeroth.game.entity.creature;

public enum ObjectCellMoveState {
    NONE, // not in move list
    ACTIVE, // in move list
    INACTIVE; // in move list but should not move
}
