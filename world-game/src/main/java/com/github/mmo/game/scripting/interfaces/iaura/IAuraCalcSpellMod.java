package com.github.mmo.game.scripting.interfaces.iaura;


import com.github.mmo.game.entity.player.model.SpellModifier;
import com.github.mmo.game.spell.AuraEffect;

public interface IAuraCalcSpellMod extends IAuraEffectHandler {
    void calcSpellMod(AuraEffect aura, SpellModifier spellMod);
}
