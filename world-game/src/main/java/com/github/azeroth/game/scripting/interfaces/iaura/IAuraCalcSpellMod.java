package com.github.azeroth.game.scripting.interfaces.iaura;


import com.github.azeroth.game.entity.player.model.SpellModifier;
import com.github.azeroth.game.spell.AuraEffect;

public interface IAuraCalcSpellMod extends IAuraEffectHandler {
    void calcSpellMod(AuraEffect aura, SpellModifier spellMod);
}
