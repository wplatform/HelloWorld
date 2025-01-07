package com.github.azeroth.defines;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Expansion {
    LEVEL_CURRENT(-1),
    CLASSIC(0),
    BURNING_CRUSADE(1),
    WRATH_OF_THE_LICH_KING(2),
    CATACLYSM(3),
    MISTS_OF_PANDARIA(4),
    WARLORDS_OF_DRAENOR(5),
    LEGION(6),
    MAX_EXPANSIONS(7),
    BATTLE_FOR_AZEROTH(7),
    MAX_ACCOUNT_EXPANSIONS(8);

    private final int value;

}
