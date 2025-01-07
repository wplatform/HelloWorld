package com.github.azeroth.dbc.defines;

public enum AbilityLearnType {
    SKILL_LINE_ABILITY_LEARNED_ON_SKILL_VALUE, // Spell state will update depending on skill value
    SKILL_LINE_ABILITY_LEARNED_ON_SKILL_LEARN, // Spell will be learned/removed together with entire skill
    SKILL_LINE_ABILITY_REWARDED_FROM_QUEST     // Learned as quest reward, also re-learned if missing
}
