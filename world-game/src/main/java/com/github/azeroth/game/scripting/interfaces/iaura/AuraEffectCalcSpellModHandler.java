package com.github.azeroth.game.scripting.interfaces.iaura;


import com.github.azeroth.game.entity.player.model.SpellModifier;
import com.github.azeroth.game.spell.AuraEffect;

public class AuraEffectCalcSpellModHandler extends AuraEffectHandler implements IAuraCalcSpellMod {
    private final tangible.Action2Param<AuraEffect, SpellModifier> fn;

    public AuraEffectCalcSpellModHandler(tangible.Action2Param<AuraEffect, SpellModifier> fn, int effectIndex, AuraType auraType) {
        super(effectIndex, auraType, AuraScriptHookType.EffectCalcSpellmod);
        fn = fn;
    }

    public final void calcSpellMod(AuraEffect aura, SpellModifier spellMod) {
        fn.invoke(aura, spellMod);
    }
}
