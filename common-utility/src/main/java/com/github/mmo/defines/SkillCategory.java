package com.github.mmo.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SkillCategory {
    SKILL_CATEGORY_UNK1(0),
    SKILL_CATEGORY_ATTRIBUTES(5),
    SKILL_CATEGORY_WEAPON(6),
    SKILL_CATEGORY_CLASS(7),
    SKILL_CATEGORY_ARMOR(8),
    SKILL_CATEGORY_SECONDARY(9),                       // secondary professions
    SKILL_CATEGORY_LANGUAGES(10),
    SKILL_CATEGORY_PROFESSION(11),                      // primary professions
    SKILL_CATEGORY_GENERIC(12);

    public final int value;
}
