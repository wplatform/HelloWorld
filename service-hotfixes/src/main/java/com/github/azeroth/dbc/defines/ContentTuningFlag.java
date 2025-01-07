package com.github.azeroth.dbc.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ContentTuningFlag implements EnumFlag.FlagValue {
    DisabledForItem(0x04),
    Horde(0x8),
    Alliance(0x10);

    public final int value;
}
