package com.github.mmo.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CreatureTypeFlags2 {
    CREATURE_TYPE_FLAG_2_UNK1(0x00000001),
    CREATURE_TYPE_FLAG_2_UNK2(0x00000002),
    CREATURE_TYPE_FLAG_2_UNK3(0x00000004),
    CREATURE_TYPE_FLAG_2_UNK4(0x00000008),
    CREATURE_TYPE_FLAG_2_UNK5(0x00000010),
    CREATURE_TYPE_FLAG_2_UNK6(0x00000020),
    CREATURE_TYPE_FLAG_2_UNK7(0x00000040),
    CREATURE_TYPE_FLAG_2_UNK8(0x00000080);
    public final int value;

}
