package com.github.mmo.game.entity.unit.enums;

public enum DamageEffectType {
    DIRECT_DAMAGE,                            // used for normal weapon damage (not for class abilities or spells)
    SPELL_DIRECT_DAMAGE,                            // spell/class abilities damage
    DOT,
    HEAL,
    NODAMAGE,                            // used also in case when damage applied to health but not applied to spell channelInterruptFlags/etc
    SELF_DAMAGE
}
