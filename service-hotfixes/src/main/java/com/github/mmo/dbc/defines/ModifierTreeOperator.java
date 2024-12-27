package com.github.mmo.dbc.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ModifierTreeOperator {
    SingleTrue(2),
    SingleFalse(3),
    All(4),
    Some(8);
    public final int value;
}
