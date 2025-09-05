package com.github.azeroth.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// EnumUtils: DESCRIBE THIS
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SpellAttr10 implements EnumFlag.FlagValue {
    UNK0(0x00000001), // TITLE Unknown attribute 0@Attr10
    UNK1(0x00000002), // TITLE Unknown attribute 1@Attr10
    USES_RANGED_SLOT_COSMETIC_ONLY(0x00000004), // TITLE Uses Ranged Slot (Cosmetic Only)
    UNK3(0x00000008), // TITLE Unknown attribute 3@Attr10
    WATER_SPOUT(0x00000010), // TITLE NPC Knockback - ignore doors
    UNK5(0x00000020), // TITLE Unknown attribute 5@Attr10
    UNK6(0x00000040), // TITLE Unknown attribute 6@Attr10
    TELEPORT_PLAYER(0x00000080), // TITLE Ignore instance lock and farm limit on teleport
    UNK8(0x00000100), // TITLE Unknown attribute 8@Attr10
    UNK9(0x00000200), // TITLE Unknown attribute 9@Attr10
    UNK10(0x00000400), // TITLE Unknown attribute 10@Attr10
    HERB_GATHERING_MINING(0x00000800), // TITLE Lock chest at precast
    USE_SPELL_BASE_LEVEL_FOR_SCALING(0x00001000), // TITLE Use Spell Base Level For Scaling
    RESET_COOLDOWN_ON_ENCOUNTER_END(0x00002000), // TITLE Reset cooldown upon ending an encounter
    ROLLING_PERIODIC(0x00004000), // TITLE Rolling Periodic DESCRIPTION Add remaining periodic damage to new aura when refreshed
    UNK15(0x00008000), // TITLE Unknown attribute 15@Attr10
    UNK16(0x00010000), // TITLE Unknown attribute 16@Attr10
    CAN_DODGE_PARRY_WHILE_CASTING(0x00020000), // TITLE Allow Defense While Casting
    UNK18(0x00040000), // TITLE Unknown attribute 18@Attr10
    UNK19(0x00080000), // TITLE Unknown attribute 19@Attr10
    UNK20(0x00100000), // TITLE Unknown attribute 20@Attr10
    UNK21(0x00200000), // TITLE Unknown attribute 21@Attr10
    UNK22(0x00400000), // TITLE Unknown attribute 22@Attr10
    UNK23(0x00800000), // TITLE Unknown attribute 23@Attr10
    UNK24(0x01000000), // TITLE Unknown attribute 24@Attr10
    UNK25(0x02000000), // TITLE Unknown attribute 25@Attr10
    UNK26(0x04000000), // TITLE Unknown attribute 26@Attr10
    UNK27(0x08000000), // TITLE Unknown attribute 27@Attr10
    UNK28(0x10000000), // TITLE Unknown attribute 28@Attr10
    MOUNT_IS_NOT_ACCOUNT_WIDE(0x20000000), // TITLE This Mount is NOT at the account level
    UNK30(0x40000000), // TITLE Unknown attribute 30@Attr10
    UNK31(0x80000000);  // TITLE Unknown attribute 31@Attr10
    public final int value;
}
