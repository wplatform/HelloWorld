package com.github.azeroth.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

// EnumUtils: DESCRIBE THIS
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SpellAttr9 {
    UNK0(0x00000001), // TITLE Unknown attribute 0@Attr9
    UNK1(0x00000002), // TITLE Unknown attribute 1@Attr9
    RESTRICTED_FLIGHT_AREA(0x00000004), // TITLE Only When Illegally Mounted
    UNK3(0x00000008), // TITLE Unknown attribute 3@Attr9
    SPECIAL_DELAY_CALCULATION(0x00000010), // TITLE Missile Speed is Delay (in sec)
    SUMMON_PLAYER_TOTEM(0x00000020), // TITLE Ignore Totem Requirements for Casting
    UNK6(0x00000040), // TITLE Unknown attribute 6@Attr9
    UNK7(0x00000080), // TITLE Unknown attribute 7@Attr9
    AIMED_SHOT(0x00000100), // TITLE Cooldown Ignores Ranged Weapon
    NOT_USABLE_IN_ARENA(0x00000200), // TITLE Not In Arena
    UNK10(0x00000400), // TITLE Unknown attribute 10@Attr9
    UNK11(0x00000800), // TITLE Unknown attribute 11@Attr9
    UNK12(0x00001000), // TITLE Unknown attribute 12@Attr9
    SLAM(0x00002000), // TITLE Haste Affects Melee Ability Casttime
    USABLE_IN_RATED_BATTLEGROUNDS(0x00004000), // TITLE Ignore Default Rated Battleground Restrictions
    UNK15(0x00008000), // TITLE Unknown attribute 15@Attr9
    UNK16(0x00010000), // TITLE Unknown attribute 16@Attr9
    UNK17(0x00020000), // TITLE Unknown attribute 17@Attr9
    UNK18(0x00040000), // TITLE Unknown attribute 18@Attr9
    UNK19(0x00080000), // TITLE Unknown attribute 19@Attr9
    UNK20(0x00100000), // TITLE Unknown attribute 20@Attr9
    UNK21(0x00200000), // TITLE Unknown attribute 21@Attr9
    UNK22(0x00400000), // TITLE Unknown attribute 22@Attr9
    UNK23(0x00800000), // TITLE Unknown attribute 23@Attr9
    UNK24(0x01000000), // TITLE Unknown attribute 24@Attr9
    UNK25(0x02000000), // TITLE Unknown attribute 25@Attr9
    UNK26(0x04000000), // TITLE Unknown attribute 26@Attr9
    UNK27(0x08000000), // TITLE Unknown attribute 27@Attr9
    UNK28(0x10000000), // TITLE Unknown attribute 28@Attr9
    UNK29(0x20000000), // TITLE Unknown attribute 29@Attr9
    UNK30(0x40000000), // TITLE Unknown attribute 30@Attr9
    UNK31(0x80000000);  // TITLE Unknown attribute 31@Attr9
    public final int value;
}
