package com.github.mmo.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SpellHitType implements EnumFlag.FlagValue {
    SPELL_HIT_TYPE_CRIT_DEBUG(0x01),
    SPELL_HIT_TYPE_CRIT(0x02),
    SPELL_HIT_TYPE_HIT_DEBUG(0x04),
    SPELL_HIT_TYPE_SPLIT(0x08),
    SPELL_HIT_TYPE_VICTIM_IS_ATTACKER(0x10),
    SPELL_HIT_TYPE_ATTACK_TABLE_DEBUG(0x20),
    SPELL_HIT_TYPE_UNK(0x40),
    SPELL_HIT_TYPE_NO_ATTACKER(0x80); // does the same as SPELL_ATTR4_COMBAT_LOG_NO_CASTER

    public final int value;
}
