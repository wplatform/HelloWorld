package com.github.mmo.defines;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum PlayerClass {
    CLASS_NONE(0),
    CLASS_WARRIOR(1),
    CLASS_PALADIN(2),
    CLASS_HUNTER(3),
    CLASS_ROGUE(4),
    CLASS_PRIEST(5),
    CLASS_DEATH_KNIGHT(6),
    CLASS_SHAMAN(7),
    CLASS_MAGE(8),
    CLASS_WARLOCK(9),
    CLASS_MONK(10),
    CLASS_DRUID(11),
    CLASS_DEMON_HUNTER(12);

    private final int value;

}
