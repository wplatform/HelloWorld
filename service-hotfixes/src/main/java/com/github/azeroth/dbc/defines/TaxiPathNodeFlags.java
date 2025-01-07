package com.github.azeroth.dbc.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum TaxiPathNodeFlags implements EnumFlag.FlagValue {
    TAXI_PATH_NODE_FLAG_TELEPORT(0x1),
    TAXI_PATH_NODE_FLAG_STOP(0x2);
    public final int value;
}
