package com.github.azeroth.game.domain.unit;

// UNIT_FIELD_BYTES_1 (UNIT_BYTES_1_OFFSET_ANIM_TIER)
public enum AnimTier {
    GROUND, // plays ground tier animations
    SWIM, // falls back to ground tier animations, not handled by the client, should never appear in sniffs, will prevent tier change animations from playing correctly if used
    HOVER, // plays flying tier animations or falls back to ground tier animations, automatically enables hover clientside when entering visibility with this value
    FLY, // plays flying tier animations
    SUBMERGED
}
