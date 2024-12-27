package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ItemExtendedCostFlags implements EnumFlag.FlagValue {
    ITEM_EXT_COST_FLAG_REQUIRE_GUILD(0x01),
    ITEM_EXT_COST_CURRENCY_REQ_IS_SEASON_EARNED_1(0x02),
    ITEM_EXT_COST_CURRENCY_REQ_IS_SEASON_EARNED_2(0x04),
    ITEM_EXT_COST_CURRENCY_REQ_IS_SEASON_EARNED_3(0x08),
    ITEM_EXT_COST_CURRENCY_REQ_IS_SEASON_EARNED_4(0x10),
    ITEM_EXT_COST_CURRENCY_REQ_IS_SEASON_EARNED_5(0x20);

    public final int value;
}
