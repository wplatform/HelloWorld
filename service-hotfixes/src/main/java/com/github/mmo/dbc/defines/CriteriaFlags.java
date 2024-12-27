package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CriteriaFlags implements EnumFlag.FlagValue {
    FailAchievement(0x01), // Fail Achievement
    ResetOnStart(0x02), // Reset on Start
    ServerOnly(0x04), // Server Only
    AlwaysSaveToDB(0x08), // Always Save to DB (Use with Caution)
    AllowCriteriaDecrement(0x10), // Allow criteria to be decremented
    IsForQuest(0x20);  // Is For Quest
    public final int value;
}
