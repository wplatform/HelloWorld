package com.github.azeroth.game.domain.misc;

import com.github.azeroth.common.EnumFlag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class InstanceSpawnGroup {
    private int instanceMapId;
    private int bossStateId;
    private byte bossStates;
    private int spawnGroupId;
    private EnumFlag<Flag> flags;

    @Getter
    @RequiredArgsConstructor
    public enum Flag implements EnumFlag.FlagValue {
        FLAG_ACTIVATE_SPAWN (0x01),
        FLAG_BLOCK_SPAWN    (0x02),
        FLAG_ALLIANCE_ONLY  (0x04),
        FLAG_HORDE_ONLY     (0x08),

        FLAG_ALL(FLAG_ACTIVATE_SPAWN.ordinal() | FLAG_BLOCK_SPAWN.ordinal() | FLAG_ALLIANCE_ONLY.ordinal() | FLAG_HORDE_ONLY.ordinal()) ;

        final int value;
    };
}