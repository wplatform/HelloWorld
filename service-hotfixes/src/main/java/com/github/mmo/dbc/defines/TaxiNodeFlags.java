package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum TaxiNodeFlags implements EnumFlag.FlagValue {
    TAXI_NODE_FLAG_ALLIANCE(0x01),
    TAXI_NODE_FLAG_HORDE(0x02),
    TAXI_NODE_FLAG_USE_FAVORITE_MOUNT(0x10);

    public final int value;
}
