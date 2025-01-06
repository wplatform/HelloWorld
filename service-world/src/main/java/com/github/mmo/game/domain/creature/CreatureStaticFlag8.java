package com.github.mmo.game.domain.creature;

import com.github.mmo.common.EnumFlag;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public
enum CreatureStaticFlag8 implements EnumFlag.FlagValue {
    FORCE_CLOSE_IN_ON_PATH_FAIL_BEHAVIOR(0x00000002),
    USE_2D_CHASING_CALCULATION(0x00000020),
    USE_FAST_CLASSIC_HEARTBEAT(0x00000040);

    public final int value;
}
