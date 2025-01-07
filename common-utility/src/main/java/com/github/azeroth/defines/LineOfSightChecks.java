package com.github.azeroth.defines;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum LineOfSightChecks {
    VMAP(0x1), // check static floor layout data
    GOBJECT(0x2), // check dynamic game object data

    ALL(VMAP.value | GOBJECT.value);

    public final int value;
}
