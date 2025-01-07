package com.github.azeroth.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CreatureTypeFlag2 implements EnumFlag.FlagValue {
    UNK1(0x00000001),
    UNK2(0x00000002),
    UNK3(0x00000004),
    UNK4(0x00000008),
    UNK5(0x00000010),
    UNK6(0x00000020),
    UNK7(0x00000040),
    UNK8(0x00000080);
    public final int value;

}
