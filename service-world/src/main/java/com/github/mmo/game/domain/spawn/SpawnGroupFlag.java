package com.github.mmo.game.domain.spawn;

import com.github.mmo.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SpawnGroupFlag implements EnumFlag.FlagValue {

    NONE                            (0x00),
    SYSTEM                          (0x01),
    COMPATIBILITY_MODE              (0x02),
    MANUAL_SPAWN                    (0x04),
    DYNAMIC_SPAWN_RATE              (0x08),
    ESCORT_QUEST_NPC                  (0x10),
    DESPAWN_ON_CONDITION_FAILURE    (0x20),

    ALL (SpawnGroupFlag.SYSTEM.value | SpawnGroupFlag.COMPATIBILITY_MODE.value | SpawnGroupFlag.MANUAL_SPAWN.value
                            | SpawnGroupFlag.DYNAMIC_SPAWN_RATE.value | SpawnGroupFlag.ESCORT_QUEST_NPC.value | SpawnGroupFlag.DESPAWN_ON_CONDITION_FAILURE.value);


    public final int value;
}
