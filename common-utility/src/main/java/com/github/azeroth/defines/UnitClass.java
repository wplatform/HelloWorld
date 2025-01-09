package com.github.azeroth.defines;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UnitClass {
    WARRIOR(1), PALADIN(2), ROGUE(4), MAGE(8);

    private final int value;
    
}
