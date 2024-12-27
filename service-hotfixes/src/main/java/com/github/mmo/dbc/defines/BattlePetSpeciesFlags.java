package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum BattlePetSpeciesFlags implements EnumFlag.FlagValue {
    NoRename(0x00001),
    WellKnown(0x00002),
    NotAccountWide(0x00004),
    Capturable(0x00008),
    NotTradable(0x00010),
    HideFromJournal(0x00020),
    LegacyAccountUnique(0x00040),
    CantBattle(0x00080),
    HordeOnly(0x00100),
    AllianceOnly(0x00200),
    Boss(0x00400),
    RandomDisplay(0x00800),
    NoLicenseRequired(0x01000),
    AddsAllowedWithBoss(0x02000),
    HideUntilLearned(0x04000),
    MatchPlayerHighPetLevel(0x08000),
    NoWildPetAddsAllowed(0x10000);

    public final int value;
}
