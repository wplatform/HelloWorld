package com.github.azeroth.game.domain.object.enums;

public enum CellMoveState {
    NONE, // not in move list
    ACTIVE, // in move list
    INACTIVE; // in move list but should not move
}
