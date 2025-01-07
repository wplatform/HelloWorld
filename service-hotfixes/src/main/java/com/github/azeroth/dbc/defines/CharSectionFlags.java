package com.github.azeroth.dbc.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CharSectionFlags implements EnumFlag.FlagValue {
    SECTION_FLAG_PLAYER(0x01),
    SECTION_FLAG_DEATH_KNIGHT(0x04),
    SECTION_FLAG_DEMON_HUNTER(0x20);
    public final int value;
}
