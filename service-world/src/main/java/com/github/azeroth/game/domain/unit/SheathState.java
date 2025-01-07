package com.github.azeroth.game.domain.unit;

// low byte (0 from 0..3) of UNIT_FIELD_BYTES_2
public enum SheathState {
    SHEATH_STATE_UNARMED,                              // non prepared weapon
    SHEATH_STATE_MELEE,                              // prepared melee weapon
    SHEATH_STATE_RANGED,                              // prepared ranged weapon

    MAX_SHEATH_STATE
}
