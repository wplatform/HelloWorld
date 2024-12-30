package com.github.mmo.game.scripting.interfaces.ispellmanager;

import com.github.mmo.game.spell.SpellInfo;

/**
 * Applies spell fixes after LoadSpellInfoImmunities, LoadSpellInfoDiminishing, LoadSpellInfoCustomAttributes and LoadSkillLineAbilityMap all have effected the spell.
 * This will override any of those calculations.
 */
public interface ISpellManagerSpellLateFix {
    int[] getSpellIds();

    void applySpellFix(SpellInfo spellInfo);
}
