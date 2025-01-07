package com.github.azeroth.dbc.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ChrSpecializationFlag implements EnumFlag.FlagValue {
    Caster(0x01),
    Ranged(0x02),
    Melee(0x04),
    DualWieldTwoHanded(0x10),     // used for CUnitDisplay::SetSheatheInvertedForDualWield
    PetOverrideSpec(0x20),
    Recommended(0x40);
    public final int value;
}
