package com.rainbowland.enums;

import java.util.Arrays;

public enum SpellSchoolMask {
    SPELL_SCHOOL_MASK_NONE(0x00),                       // not exist
    SPELL_SCHOOL_MASK_NORMAL(1 << SpellSchools.SPELL_SCHOOL_NORMAL.ordinal()), // PHYSICAL (Armor)
    SPELL_SCHOOL_MASK_HOLY(1 << SpellSchools.SPELL_SCHOOL_HOLY.ordinal()),
    SPELL_SCHOOL_MASK_FIRE(1 << SpellSchools.SPELL_SCHOOL_FIRE.ordinal()),
    SPELL_SCHOOL_MASK_NATURE(1 << SpellSchools.SPELL_SCHOOL_NATURE.ordinal()),
    SPELL_SCHOOL_MASK_FROST(1 << SpellSchools.SPELL_SCHOOL_FROST.ordinal()),
    SPELL_SCHOOL_MASK_SHADOW(1 << SpellSchools.SPELL_SCHOOL_SHADOW.ordinal()),
    SPELL_SCHOOL_MASK_ARCANE(1 << SpellSchools.SPELL_SCHOOL_ARCANE.ordinal()),

    // unions

    // 124, not include normal and holy damage
    SPELL_SCHOOL_MASK_SPELL(SPELL_SCHOOL_MASK_FIRE.val() |
            SPELL_SCHOOL_MASK_NATURE.val() | SPELL_SCHOOL_MASK_FROST.val() |
            SPELL_SCHOOL_MASK_SHADOW.val() | SPELL_SCHOOL_MASK_ARCANE.val()),
    // 126
    SPELL_SCHOOL_MASK_MAGIC(SPELL_SCHOOL_MASK_HOLY.val() | SPELL_SCHOOL_MASK_SPELL.val()),

    // 127
    SPELL_SCHOOL_MASK_ALL(SPELL_SCHOOL_MASK_NORMAL.val() | SPELL_SCHOOL_MASK_MAGIC.val());


    private final int value;

    SpellSchoolMask(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }

    SpellSchools getFirstSchoolInMask(SpellSchoolMask mask) {
        return Arrays.stream(SpellSchools.values())
                .filter(v -> (mask.val() & (1 << v.ordinal())) != 0)
                .findFirst()
                .orElse(SpellSchools.SPELL_SCHOOL_NORMAL);
    }
}
