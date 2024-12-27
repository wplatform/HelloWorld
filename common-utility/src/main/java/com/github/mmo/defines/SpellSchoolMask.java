package com.github.mmo.defines;

public enum SpellSchoolMask {
    NONE(0x00),
    NORMAL(1 << SpellSchool.NORMAL.ordinal()),
    HOLY(1 << SpellSchool.HOLY.ordinal()),
    FIRE(1 << SpellSchool.FIRE.ordinal()),
    NATURE(1 << SpellSchool.NATURE.ordinal()),
    FROST(1 << SpellSchool.FROST.ordinal()),
    SHADOW(1 << SpellSchool.SHADOW.ordinal()),
    ARCANE(1 << SpellSchool.ARCANE.ordinal()),
    SPELL(FIRE.value | NATURE.value | FROST.value | SHADOW.value | ARCANE.value),
    MAGIC(HOLY.value | SPELL.value), ALL(NORMAL.value | MAGIC.value);

    public final int value;

    SpellSchoolMask(int value) {
        this.value = value;
    }
}
