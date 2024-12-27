package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CorruptionEffectsFlag implements EnumFlag.FlagValue {
    CHR_SPECIALIZATION_FLAG_CASTER(0x01),
    CHR_SPECIALIZATION_FLAG_RANGED(0x02),
    CHR_SPECIALIZATION_FLAG_MELEE(0x04),
    CHR_SPECIALIZATION_FLAG_UNKNOWN(0x08),
    CHR_SPECIALIZATION_FLAG_DUAL_WIELD_TWO_HANDED(0x10),     // used for CUnitDisplay::SetSheatheInvertedForDualWield
    CHR_SPECIALIZATION_FLAG_PET_OVERRIDE_SPEC(0x20),
    CHR_SPECIALIZATION_FLAG_RECOMMENDED(0x40);

    public final int value;
}
