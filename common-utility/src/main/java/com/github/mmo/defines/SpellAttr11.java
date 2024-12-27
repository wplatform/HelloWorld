package com.github.mmo.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

// EnumUtils: DESCRIBE THIS
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SpellAttr11 {
    UNK0(0x00000001), // TITLE Unknown attribute 0@Attr11
    UNK1(0x00000002), // TITLE Unknown attribute 1@Attr11
    SCALES_WITH_ITEM_LEVEL(0x00000004), // TITLE Scales with Casting Item's Level
    UNK3(0x00000008), // TITLE Unknown attribute 3@Attr11
    UNK4(0x00000010), // TITLE Unknown attribute 4@Attr11
    ABSORB_ENVIRONMENTAL_DAMAGE(0x00000020), // TITLE Absorb Falling Damage
    UNK6(0x00000040), // TITLE Unknown attribute 6@Attr11
    RANK_IGNORES_CASTER_LEVEL(0x00000080), // TITLE Ignore Caster's spell level DESCRIPTION Spell_C_GetSpellRank returns SpellLevels->MaxLevel * 5 instead of std::min(SpellLevels->MaxLevel, caster->Level) * 5
    UNK8(0x00000100), // TITLE Unknown attribute 8@Attr11
    UNK9(0x00000200), // TITLE Unknown attribute 9@Attr11
    UNK10(0x00000400), // TITLE Unknown attribute 10@Attr11
    NOT_USABLE_IN_INSTANCES(0x00000800), // TITLE Not in Instances
    UNK12(0x00001000), // TITLE Unknown attribute 12@Attr11
    UNK13(0x00002000), // TITLE Unknown attribute 13@Attr11
    UNK14(0x00004000), // TITLE Unknown attribute 14@Attr11
    UNK15(0x00008000), // TITLE Unknown attribute 15@Attr11
    NOT_USABLE_IN_CHALLENGE_MODE(0x00010000), // TITLE Not in Mythic+ Mode (Challenge Mode)
    UNK17(0x00020000), // TITLE Unknown attribute 17@Attr11
    UNK18(0x00040000), // TITLE Unknown attribute 18@Attr11
    UNK19(0x00080000), // TITLE Unknown attribute 19@Attr11
    UNK20(0x00100000), // TITLE Unknown attribute 20@Attr11
    UNK21(0x00200000), // TITLE Unknown attribute 21@Attr11
    UNK22(0x00400000), // TITLE Unknown attribute 22@Attr11
    UNK23(0x00800000), // TITLE Unknown attribute 23@Attr11
    UNK24(0x01000000), // TITLE Unknown attribute 24@Attr11
    UNK25(0x02000000), // TITLE Unknown attribute 25@Attr11
    UNK26(0x04000000), // TITLE Unknown attribute 26@Attr11
    UNK27(0x08000000), // TITLE Unknown attribute 27@Attr11
    UNK28(0x10000000), // TITLE Unknown attribute 28@Attr11
    UNK29(0x20000000), // TITLE Unknown attribute 29@Attr11
    UNK30(0x40000000), // TITLE Unknown attribute 30@Attr11
    UNK31(0x80000000);  // TITLE Unknown attribute 31@Attr11
    public final int value;
}
