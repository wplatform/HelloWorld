package com.github.azeroth.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)

public enum Power {

    HEALTH(-2),
    MANA(0),
    RAGE(1),
    FOCUS(2),
    ENERGY(3),
    COMBO_POINTS(4),
    RUNES(5),
    RUNIC_POWER(6),
    SOUL_SHARDS(7),
    LUNAR_POWER(8),
    HOLY_POWER(9),
    ALTERNATE_POWER(10),
    MAELSTROM(11),
    CHI(12),
    INSANITY(13),
    BURNING_EMBERS(14),
    DEMONIC_FURY(15),
    ARCANE_CHARGES(16),
    FURY(17),
    PAIN(18),
    ESSENCE(19),
    MAX_POWERS(20),
    POWER_ALL(127);

    public final int index;

}
