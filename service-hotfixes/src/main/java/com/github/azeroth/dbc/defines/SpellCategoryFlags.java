package com.github.azeroth.dbc.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SpellCategoryFlags implements EnumFlag.FlagValue {
    SPELL_CATEGORY_FLAG_COOLDOWN_SCALES_WITH_WEAPON_SPEED(0x01), // unused
    SPELL_CATEGORY_FLAG_COOLDOWN_STARTS_ON_EVENT(0x04),
    SPELL_CATEGORY_FLAG_COOLDOWN_EXPIRES_AT_DAILY_RESET(0x08);

    public final int value;
}
