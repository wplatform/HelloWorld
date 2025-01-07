package com.github.azeroth.game.domain.unit;

public enum VictimState {
    VICTIMSTATE_INTACT, // set when attacker misses
    VICTIMSTATE_HIT, // victim got clear/blocked hit
    VICTIMSTATE_DODGE,
    VICTIMSTATE_PARRY,
    VICTIMSTATE_INTERRUPT,
    VICTIMSTATE_BLOCKS, // unused? not set when blocked, even on full block
    VICTIMSTATE_EVADES,
    VICTIMSTATE_IS_IMMUNE,
    VICTIMSTATE_DEFLECTS
}
