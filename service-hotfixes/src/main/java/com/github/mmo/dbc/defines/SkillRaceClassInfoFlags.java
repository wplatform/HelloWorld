package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SkillRaceClassInfoFlags implements EnumFlag.FlagValue {
    SKILL_FLAG_NO_SKILLUP_MESSAGE(0x2),
    SKILL_FLAG_ALWAYS_MAX_VALUE(0x10),
    SKILL_FLAG_UNLEARNABLE(0x20),     // Skill can be unlearned
    SKILL_FLAG_INCLUDE_IN_SORT(0x80),     // Spells belonging to a skill with this flag will additionally compare skill ids when sorting spellbook in client
    SKILL_FLAG_NOT_TRAINABLE(0x100),
    SKILL_FLAG_MONO_VALUE(0x400);     // Skill always has value 1 - clientside display flag, real value can be different

    public final int value;
}
