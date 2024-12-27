package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ArtifactPowerFlag implements EnumFlag.FlagValue {
    ARTIFACT_POWER_FLAG_GOLD(0x01),
    ARTIFACT_POWER_FLAG_NO_LINK_REQUIRED(0x02),
    ARTIFACT_POWER_FLAG_FINAL(0x04),
    ARTIFACT_POWER_FLAG_SCALES_WITH_NUM_POWERS(0x08),
    ARTIFACT_POWER_FLAG_DONT_COUNT_FIRST_BONUS_RANK(0x10),
    ARTIFACT_POWER_FLAG_MAX_RANK_WITH_TIER(0x20),

    ARTIFACT_POWER_FLAG_FIRST(ARTIFACT_POWER_FLAG_NO_LINK_REQUIRED.value | ARTIFACT_POWER_FLAG_DONT_COUNT_FIRST_BONUS_RANK.value);
    public final int value;
}
