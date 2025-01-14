package com.github.azeroth.dbc.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public
// PhaseUseFlags fields in different db2s
enum PhaseUseFlag implements EnumFlag.FlagValue {
    NONE(0x0),
    ALWAYS_VISIBLE(0x1),
    INVERSE(0x2),

    ALL(ALWAYS_VISIBLE.value | INVERSE.value);

    public final int value;
}
