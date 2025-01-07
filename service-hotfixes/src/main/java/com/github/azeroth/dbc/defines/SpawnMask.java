package com.github.azeroth.dbc.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SpawnMask implements EnumFlag.FlagValue {
    CONTINENT(1 << Difficulty.NONE.ordinal()), // any maps without spawn modes

    DUNGEON_NORMAL(1 << Difficulty.NORMAL.ordinal()),
    DUNGEON_HEROIC(1 << Difficulty.HEROIC.ordinal()),
    DUNGEON_ALL(DUNGEON_NORMAL.value | DUNGEON_HEROIC.value),

    RAID_10MAN_NORMAL(1 << Difficulty.RAID_10_N.ordinal()),
    RAID_25MAN_NORMAL(1 << Difficulty.RAID_25_N.ordinal()),
    RAID_NORMAL_ALL(RAID_10MAN_NORMAL.value | RAID_25MAN_NORMAL.value),

    RAID_10MAN_HEROIC(1 << Difficulty.RAID_10_HC.ordinal()),
    RAID_25MAN_HEROIC(1 << Difficulty.RAID_25_HC.ordinal()),
    RAID_HEROIC_ALL(RAID_10MAN_HEROIC.value | RAID_25MAN_HEROIC.value),

    RAID_ALL(RAID_NORMAL_ALL.value | RAID_HEROIC_ALL.value);

    public final int value;
}
