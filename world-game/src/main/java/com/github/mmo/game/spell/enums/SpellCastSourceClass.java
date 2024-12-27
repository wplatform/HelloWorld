package com.github.mmo.game.spell.enums;

import com.github.mmo.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SpellCastSourceClass implements EnumFlag.FlagValue {
    SPELL_CAST_SOURCE_PLAYER(2),
    SPELL_CAST_SOURCE_NORMAL(3),
    SPELL_CAST_SOURCE_ITEM(4),
    SPELL_CAST_SOURCE_PASSIVE(7),
    SPELL_CAST_SOURCE_PET(9),
    SPELL_CAST_SOURCE_AURA(13),
    SPELL_CAST_SOURCE_SPELL(16);

    public final int value;
}
