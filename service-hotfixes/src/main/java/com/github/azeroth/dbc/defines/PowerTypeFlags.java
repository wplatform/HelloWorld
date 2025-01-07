package com.github.azeroth.dbc.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum PowerTypeFlags implements EnumFlag.FlagValue {
    StopRegenWhileCasting(0x0001), // NYI
    UseRegenInterrupt(0x0002),
    FillFractionalPowerOnEnergize(0x0008), // NYI
    NoClientPrediction(0x0010), // NYI
    UnitsUseDefaultPowerOnInit(0x0020),
    NotSetToDefaultOnResurrect(0x0040), // NYI
    IsUsedByNPCs(0x0080),
    ContinueRegenWhileFatigued(0x0200), // NYI
    RegenAffectedByHaste(0x0400), // NYI
    SetToMaxOnLevelUp(0x1000),
    SetToMaxLevelOnInitialLogIn(0x2000), // NYI
    AllowCostModsForPlayers(0x4000);  // NYI

    public final int value;
}
