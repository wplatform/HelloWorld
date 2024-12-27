package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum MapDifficultyFlag implements EnumFlag.FlagValue {
    LimitToPlayersFromOneRealm(0x01),
    UseLootBasedLockInsteadOfInstanceLock(0x02), // Lock to single encounters
    LockedToSoloOwner(0x04),
    ResumeDungeonProgressBasedOnLockout(0x08), // Mythic dungeons with this flag zone into leaders instance instead of always using a fresh one (Return to Karazhan, Operation: Mechagon)
    DisableLockExtension(0x10);

    public final int value;
}
