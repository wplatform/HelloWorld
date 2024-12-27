package com.github.mmo.game.entity.unit.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// byte flag value (UNIT_FIELD_BYTES_1, 2)
@Getter
@RequiredArgsConstructor
public enum  UnitVisFlags {
    UNIT_VIS_FLAGS_INVISIBLE(0x01),
    UNIT_VIS_FLAGS_STEALTHED(0x02),
    UNIT_VIS_FLAGS_UNTRACKABLE(0x04),
    UNIT_VIS_FLAGS_UNK4(0x08),
    UNIT_VIS_FLAGS_UNK5(0x10),
    UNIT_VIS_FLAGS_ALL(0xFF);

    public final int value;
}
