package com.rainbowland.enums;

public enum SpellHitType {
    SPELL_HIT_TYPE_CRIT_DEBUG(0x01),
    SPELL_HIT_TYPE_CRIT(0x02),
    SPELL_HIT_TYPE_HIT_DEBUG(0x04),
    SPELL_HIT_TYPE_SPLIT(0x08),
    SPELL_HIT_TYPE_VICTIM_IS_ATTACKER(0x10),
    SPELL_HIT_TYPE_ATTACK_TABLE_DEBUG(0x20),
    SPELL_HIT_TYPE_UNK(0x40),
    SPELL_HIT_TYPE_NO_ATTACKER(0x80); // does the same as SPELL_ATTR4_COMBAT_LOG_NO_CASTER

    private final int value;

    SpellHitType(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
