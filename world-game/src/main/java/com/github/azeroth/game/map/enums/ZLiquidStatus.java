package com.github.azeroth.game.map.enums;

import com.github.azeroth.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter(onMethod = @__({@Override}))
@RequiredArgsConstructor
public enum ZLiquidStatus implements EnumFlag.FlagValue {

    NO_WATER(0x00000000),
    ABOVE_WATER(0x00000001),
    WATER_WALK(0x00000002),
    IN_WATER(0x00000004),
    UNDER_WATER(0x00000008),
    OCEAN_FLOOR(0x00000010);
    public final int value;
}
