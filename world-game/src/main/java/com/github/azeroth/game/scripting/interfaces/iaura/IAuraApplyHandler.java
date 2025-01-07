package com.github.azeroth.game.scripting.interfaces.iaura;


import com.github.azeroth.game.spell.AuraEffect;

public interface IAuraApplyHandler extends IAuraEffectHandler {
    AuraEffectHandleModes getModes();

    void apply(AuraEffect aura, AuraEffectHandleModes auraMode);
}
