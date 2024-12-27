package com.github.mmo.defines;

import lombok.RequiredArgsConstructor;

// loot modes for creatures and gameobjects, bitmask!
@RequiredArgsConstructor
public enum LootMode {
    DEFAULT(0x1),
    HARD_MODE_1(0x2),
    HARD_MODE_2(0x4),
    HARD_MODE_3(0x8),
    HARD_MODE_4(0x10),
    JUNK_FISH(0x8000);

    public final int value;
}
