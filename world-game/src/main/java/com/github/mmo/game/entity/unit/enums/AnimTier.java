package com.github.mmo.game.entity.unit.enums;

// UNIT_FIELD_BYTES_1 (UNIT_BYTES_1_OFFSET_ANIM_TIER)
public enum AnimTier {
    ground, // plays ground tier animations
    swim, // falls back to ground tier animations, not handled by the client, should never appear in sniffs, will prevent tier change animations from playing correctly if used
    Hover, // plays flying tier animations or falls back to ground tier animations, automatically enables hover clientside when entering visibility with this value
    Fly, // plays flying tier animations
    Submerged
}
