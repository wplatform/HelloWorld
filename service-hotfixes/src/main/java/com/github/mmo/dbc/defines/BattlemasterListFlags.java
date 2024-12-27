package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum BattlemasterListFlags implements EnumFlag.FlagValue {
    InternalOnly(0x01),
    RatedOnly(0x02), // Only set for rated battlegrounds
    ObsoleteDoNotList(0x04),
    ShowInWarGames(0x08),
    ShowInPvpBattlegroundList(0x10),
    IsBrawl(0x20),
    IsFactional(0x40),
    IsEpic(0x80);
    public final int value;
}
