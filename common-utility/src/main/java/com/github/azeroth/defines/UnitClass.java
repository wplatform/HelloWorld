package com.github.azeroth.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UnitClass implements EnumFlag.FlagValue {
    WARRIOR(1), PALADIN(2), ROGUE(4), MAGE(8);

    public final int value;
    
}
