package com.github.mmo.game.phasing;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PhaseFlag {
    NONE((short) 0x0),
    COSMETIC((short) 0x1),
    PERSONAL((short) 0x2);

    public final short value;
}
