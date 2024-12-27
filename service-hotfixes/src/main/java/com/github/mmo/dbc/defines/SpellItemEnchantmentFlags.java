package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SpellItemEnchantmentFlags implements EnumFlag.FlagValue {
    Soulbound(0x001),
    DoNotLog(0x002),
    MainhandOnly(0x004),
    AllowEnteringArena(0x008),
    DoNotSaveToDB(0x010),
    ScaleAsAGem(0x020),
    DisableInChallengeModes(0x040),
    DisableInProvingGrounds(0x080),
    AllowTransmog(0x100),
    HideUntilCollected(0x200);

    public final int value;
}
