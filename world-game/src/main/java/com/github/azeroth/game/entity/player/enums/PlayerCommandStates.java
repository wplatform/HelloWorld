package com.github.azeroth.game.entity.player.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public
enum PlayerCommandStates {
    CHEAT_NONE(0x00),
    CHEAT_GOD(0x01),
    CHEAT_CAST_TIME(0x02),
    CHEAT_COOLDOWN(0x04),
    CHEAT_POWER(0x08),
    CHEAT_WATER_WALK(0x10);

    public final int value;
}
