package com.github.azeroth.game.scripting.interfaces.ispellmanager;

import com.github.azeroth.game.spell.SpellInfo;

/**
 * Applies spell fixes before LoadSpellInfoImmunities, LoadSpellInfoDiminishing, LoadSpellInfoCustomAttributes and LoadSkillLineAbilityMap all have effected the spell.
 * This will override any of those calculations.
 */
public interface ISpellManagerSpellFix {
    int[] getSpellIds();

    void applySpellFix(SpellInfo spellInfo);
}
