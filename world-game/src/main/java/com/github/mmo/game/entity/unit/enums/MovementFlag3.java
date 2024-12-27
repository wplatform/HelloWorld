package com.github.mmo.game.entity.unit.enums;

import com.github.mmo.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MovementFlag3 implements EnumFlag.FlagValue {
    NONE(0x00000000),
    DISABLE_INERTIA(0x00000001),
    CAN_ADV_FLY(0x00000002),
    ADV_FLYING(0x00000004);

    public final int value;
}
