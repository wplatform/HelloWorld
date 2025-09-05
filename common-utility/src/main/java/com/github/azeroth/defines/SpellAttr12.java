package com.github.azeroth.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// EnumUtils: DESCRIBE THIS
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SpellAttr12 implements EnumFlag.FlagValue {
    ENABLE_PROCS_FROM_SUPPRESSED_CASTER_PROCS(0x00000001), // TITLE Enable Procs from Suppressed Caster Procs
    CAN_PROC_FROM_SUPPRESSED_CASTER_PROCS(0x00000002), // TITLE Can Proc from Suppressed Caster Procs
    UNK2(0x00000004), // TITLE Unknown attribute 2@Attr12
    UNK3(0x00000008), // TITLE Unknown attribute 3@Attr12
    UNK4(0x00000010), // TITLE Unknown attribute 4@Attr12
    UNK5(0x00000020), // TITLE Unknown attribute 5@Attr12
    UNK6(0x00000040), // TITLE Unknown attribute 6@Attr12
    UNK7(0x00000080), // TITLE Unknown attribute 7@Attr12
    UNK8(0x00000100), // TITLE Unknown attribute 8@Attr12
    IGNORE_CASTING_DISABLED(0x00000200), // TITLE Active Passive DESCRIPTION Ignores aura 263 SPELL_AURA_DISABLE_CASTING_EXCEPT_ABILITIES
    UNK10(0x00000400), // TITLE Unknown attribute 10@Attr12
    UNK11(0x00000800), // TITLE Unknown attribute 11@Attr12
    UNK12(0x00001000), // TITLE Unknown attribute 12@Attr12
    UNK13(0x00002000), // TITLE Unknown attribute 13@Attr12
    UNK14(0x00004000), // TITLE Unknown attribute 14@Attr12
    UNK15(0x00008000), // TITLE Unknown attribute 15@Attr12
    UNK16(0x00010000), // TITLE Unknown attribute 16@Attr12
    UNK17(0x00020000), // TITLE Unknown attribute 17@Attr12
    UNK18(0x00040000), // TITLE Unknown attribute 18@Attr12
    UNK19(0x00080000), // TITLE Unknown attribute 19@Attr12
    UNK20(0x00100000), // TITLE Unknown attribute 20@Attr12
    UNK21(0x00200000), // TITLE Unknown attribute 21@Attr12
    UNK22(0x00400000), // TITLE Unknown attribute 22@Attr12
    START_COOLDOWN_ON_CAST_START(0x00800000), // TITLE Trigger Cooldown On Spell Start
    IS_GARRISON_BUFF(0x01000000), // TITLE Never Learn
    UNK25(0x02000000), // TITLE Unknown attribute 25@Attr12
    UNK26(0x04000000), // TITLE Unknown attribute 26@Attr12
    IS_READINESS_SPELL(0x08000000), // TITLE Recompute Aura on Mercenary Mode
    UNK28(0x10000000), // TITLE Unknown attribute 28@Attr12
    UNK29(0x20000000), // TITLE Unknown attribute 29@Attr12
    UNK30(0x40000000), // TITLE Unknown attribute 30@Attr12
    ONLY_PROC_FROM_CLASS_ABILITIES(0x80000000);  // TITLE Only Proc From Class Abilities
    public final int value;
}
