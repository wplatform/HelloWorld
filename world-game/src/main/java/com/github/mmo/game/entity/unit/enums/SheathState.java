package com.github.mmo.game.entity.unit.enums;

// low byte (0 from 0..3) of UNIT_FIELD_BYTES_2
public enum SheathState {
    SHEATH_STATE_UNARMED,                              // non prepared weapon
    SHEATH_STATE_MELEE,                              // prepared melee weapon
    SHEATH_STATE_RANGED,                              // prepared ranged weapon

    MAX_SHEATH_STATE
}
