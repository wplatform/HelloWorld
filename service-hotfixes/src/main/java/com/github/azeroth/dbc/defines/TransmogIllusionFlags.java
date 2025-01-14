package com.github.azeroth.dbc.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter(onMethod_ = {@Override})
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum TransmogIllusionFlags implements EnumFlag.FlagValue {
    HideUntilCollected(0x1),
    PlayerConditionGrantsOnLogin(0x2);

    public final int value;
}
