package com.github.azeroth.game.domain.unit;

import com.github.azeroth.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// byte flag value (UNIT_FIELD_BYTES_1, 2)
@Getter
@RequiredArgsConstructor
public enum UnitStandFlags implements EnumFlag.FlagValue {
    UNIT_STAND_FLAGS_UNK1(0x01),
    UNIT_STAND_FLAGS_CREEP(0x02),
    UNIT_STAND_FLAGS_UNTRACKABLE(0x04),
    UNIT_STAND_FLAGS_UNK4(0x08),
    UNIT_STAND_FLAGS_UNK5(0x10),
    UNIT_STAND_FLAGS_ALL(0xFF);

    public final int value;
}
