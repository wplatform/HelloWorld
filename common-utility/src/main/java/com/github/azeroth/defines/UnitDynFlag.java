package com.github.azeroth.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter(onMethod = @__({@Override}))
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum UnitDynFlag implements EnumFlag.FlagValue {
    NONE(0x0000),
    HIDE_MODEL(0x0002), // Object model is not shown with this flag
    LOOTABLE(0x0004),
    TRACK_UNIT(0x0008),
    TAPPED(0x0010), // Lua_UnitIsTapped
    SPECIAL_INFO(0x0020),
    CAN_SKIN(0x0040),
    REFER_A_FRIEND(0x0080);

    public final int value;
}
