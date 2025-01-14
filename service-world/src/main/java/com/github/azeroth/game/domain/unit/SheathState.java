package com.github.azeroth.game.domain.unit;

// low byte (0 from 0..3) of UNIT_FIELD_BYTES_2
public enum SheathState {
    UNARMED,                              // non prepared weapon
    MELEE,                              // prepared melee weapon
    RANGED                              // prepared ranged weapon
}
