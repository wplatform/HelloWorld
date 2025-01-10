package com.github.azeroth.defines;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Expansion {
    CLASSIC(0, 60),
    THE_BURNING_CRUSADE(1, 70),
    WRATH_OF_THE_LICH_KING(2, 80),
    CATACLYSM(3, 85),
    MISTS_OF_PANDARIA(4, 90),
    WARLORDS_OF_DRAENOR(5, 10),
    LEGION(6, 110);
    private final int value;
    private final int level;

}
