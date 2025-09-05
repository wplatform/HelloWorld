package com.github.azeroth.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

// EnumUtils: DESCRIBE THIS
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SpellFamilyName {
    GENERIC(0),  // TITLE Generic
    UNK1(1),  // TITLE Unk1 (events, holidays, ...)
    // 2 - unused
    MAGE(3),  // TITLE Mage
    WARRIOR(4),  // TITLE Warrior
    WARLOCK(5),  // TITLE Warlock
    PRIEST(6),  // TITLE Priest
    DRUID(7),  // TITLE Druid
    ROGUE(8),  // TITLE Rogue
    HUNTER(9),  // TITLE Hunter
    PALADIN(10), // TITLE Paladin
    SHAMAN(11), // TITLE Shaman
    UNK2(12), // TITLE Unk2 (Silence resistance?)
    POTION(13), // TITLE Potion
    // 14 - unused
    DEATH_KNIGHT(15), // TITLE Death Knight
    // 16 - unused
    PET(17), // TITLE Pet
    TOTEMS(50),
    MONK(53),
    WARLOCK_PET(57),
    UNK66(66),
    UNK71(71),
    UNK78(78),
    UNK91(91),
    UNK100(100),
    DEMON_HUNTER(107);

    public final int value;
}
