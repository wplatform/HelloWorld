package com.github.mmo.game.phasing;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PhaseShiftFlag {
    NONE(0x00),
    ALWAYS_VISIBLE(0x01), // Ignores all phasing, can see everything and be seen by everything
    INVERSE(0x02), // By default having at least one shared phase for two objects means they can see each other
    // this flag makes objects see each other if they have at least one non-shared phase
    INVERSE_UN_PHASED(0x04),
    UN_PHASED(0x08),
    NO_COSMETIC(0x10);  // This flag ignores shared cosmetic phases (two players that both have shared cosmetic phase but no other phase cannot see each other)
    public final int value;
}
