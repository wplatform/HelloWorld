package com.rainbowland.enums;

public enum SpellAttr8 {
    SPELL_ATTR8_CANT_MISS(0x00000001), //  0
    SPELL_ATTR8_UNK1(0x00000002), //  1
    SPELL_ATTR8_UNK2(0x00000004), //  2
    SPELL_ATTR8_UNK3(0x00000008), //  3
    SPELL_ATTR8_UNK4(0x00000010), //  4
    SPELL_ATTR8_UNK5(0x00000020), //  5
    SPELL_ATTR8_UNK6(0x00000040), //  6
    SPELL_ATTR8_UNK7(0x00000080), //  7
    SPELL_ATTR8_AFFECT_PARTY_AND_RAID(0x00000100), //  8 Nearly all spells have "all party and raid" in description
    SPELL_ATTR8_DONT_RESET_PERIODIC_TIMER(0x00000200), //  9 Periodic auras with this flag keep old periodic timer when refreshing at close to one tick remaining (kind of anti DoT clipping)
    SPELL_ATTR8_NAME_CHANGED_DURING_TRANSFORM(0x00000400), // 10 according to wowhead comments, name changes, title remains
    SPELL_ATTR8_UNK11(0x00000800), // 11
    SPELL_ATTR8_AURA_SEND_AMOUNT(0x00001000), // 12 Aura must have flag AFLAG_ANY_EFFECT_AMOUNT_SENT to send amount
    SPELL_ATTR8_UNK13(0x00002000), // 13
    SPELL_ATTR8_UNK14(0x00004000), // 14
    SPELL_ATTR8_WATER_MOUNT(0x00008000), // 15 only one River Boat used in Thousand Needles
    SPELL_ATTR8_UNK16(0x00010000), // 16
    SPELL_ATTR8_UNK17(0x00020000), // 17
    SPELL_ATTR8_REMEMBER_SPELLS(0x00040000), // 18 at some point in time, these auras remember spells and allow to cast them later
    SPELL_ATTR8_USE_COMBO_POINTS_ON_ANY_TARGET(0x00080000), // 19 allows to consume combo points from dead targets
    SPELL_ATTR8_ARMOR_SPECIALIZATION(0x00100000), // 20
    SPELL_ATTR8_UNK21(0x00200000), // 21
    SPELL_ATTR8_UNK22(0x00400000), // 22
    SPELL_ATTR8_BATTLE_RESURRECTION(0x00800000), // 23 Used to limit the Amount of Resurrections in Boss Encounters
    SPELL_ATTR8_HEALING_SPELL(0x01000000), // 24
    SPELL_ATTR8_UNK25(0x02000000), // 25
    SPELL_ATTR8_RAID_MARKER(0x04000000), // 26 probably spell no need learn to cast
    SPELL_ATTR8_UNK27(0x08000000), // 27
    SPELL_ATTR8_NOT_IN_BG_OR_ARENA(0x10000000), // 28 not allow to cast or deactivate currently active effect, not sure about Fast Track
    SPELL_ATTR8_MASTERY_SPECIALIZATION(0x20000000), // 29
    SPELL_ATTR8_UNK30(0x40000000), // 30
    SPELL_ATTR8_ATTACK_IGNORE_IMMUNE_TO_PC_FLAG(0x80000000); // 31 Do not check UNIT_FLAG_IMMUNE_TO_PC in IsValidAttackTarget


    private final int value;

    SpellAttr8(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
