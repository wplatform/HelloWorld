package com.github.azeroth.game.domain.unit;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// byte flags value (UNIT_FIELD_BYTES_1, 3)
@Getter

@RequiredArgsConstructor
public enum UnitBytes1_Flags {
    UNIT_BYTE1_FLAG_ALWAYS_STAND(0x01),
    UNIT_BYTE1_FLAG_HOVER(0x02),
    UNIT_BYTE1_FLAG_UNK_3(0x04),
    UNIT_BYTE1_FLAG_ALL(0xFF);

    public final int value;
}
