package com.github.mmo.game.entity.object.enums;

import com.github.mmo.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NotifyFlag implements EnumFlag.FlagValue {
    NONE(0x00),
    AI_RELOCATION(0x01),
    VISIBILITY_CHANGED(0x02),
    ALL(0xFF);
    public final int value;
}
