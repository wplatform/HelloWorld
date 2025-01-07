package com.github.azeroth.game.domain.unit;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HitInfo {
    HITINFO_NORMALSWING(0x00000000),
    HITINFO_UNK1(0x00000001),               // req correct packet structure
    HITINFO_AFFECTS_VICTIM(0x00000002),
    HITINFO_OFFHAND(0x00000004),
    HITINFO_UNK2(0x00000008),
    HITINFO_MISS(0x00000010),
    HITINFO_FULL_ABSORB(0x00000020),
    HITINFO_PARTIAL_ABSORB(0x00000040),
    HITINFO_FULL_RESIST(0x00000080),
    HITINFO_PARTIAL_RESIST(0x00000100),
    HITINFO_CRITICALHIT(0x00000200),               // critical hit
    HITINFO_UNK10(0x00000400),
    HITINFO_UNK11(0x00000800),
    HITINFO_UNK12(0x00001000),
    HITINFO_BLOCK(0x00002000),               // blocked damage
    HITINFO_UNK14(0x00004000),               // set only if meleespellid is present//  no world text when victim is hit for 0 dmg(HideWorldTextForNoDamage?)
    HITINFO_UNK15(0x00008000),               // player victim?// something related to blod sprut visual (BloodSpurtInBack?)
    HITINFO_GLANCING(0x00010000),
    HITINFO_CRUSHING(0x00020000),
    HITINFO_NO_ANIMATION(0x00040000),
    HITINFO_UNK19(0x00080000),
    HITINFO_UNK20(0x00100000),
    HITINFO_SWINGNOHITSOUND(0x00200000),               // unused?
    HITINFO_UNK22(0x00400000),
    HITINFO_RAGE_GAIN(0x00800000),
    HITINFO_FAKE_DAMAGE(0x01000000);                // enables damage animation even if no damage done, set only if no damage

    public final int value;
}
