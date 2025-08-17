package com.github.azeroth.game.domain.map.enums;

import com.github.azeroth.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum LiquidHeaderTypeFlag implements EnumFlag.FlagValue {

    NoWater(0x00),
    Water(0x01),
    Ocean(0x02),
    Magma(0x04),
    Slime(0x08),
    DarkWater(0x10),

    AllLiquids(Water.value | Ocean.value | Magma.value | Slime.value);

    @Getter(onMethod = @__({@Override}))
    private final int value;

    public static LiquidHeaderTypeFlag valueOf(final int value) {
        return Arrays.stream(values()).filter(flag -> flag.value == value).findFirst().orElseThrow();
    }

}
