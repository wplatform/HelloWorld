package com.github.azeroth.game.domain.map.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ModelFlags {
    M2(1),
    HasBound(1 << 1),
    ParentSpawn(1 << 2);

    public final int value;

}
