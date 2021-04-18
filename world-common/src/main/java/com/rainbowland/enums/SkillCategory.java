package com.rainbowland.enums;

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

    private final int value;

    SkillCategory(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
