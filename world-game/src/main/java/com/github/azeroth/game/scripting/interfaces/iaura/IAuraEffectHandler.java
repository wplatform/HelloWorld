package com.github.azeroth.game.scripting.interfaces.iaura;


public interface IAuraEffectHandler {
    int getEffectIndex();

    AuraType getAuraType();

    AuraScriptHookType getHookType();
}
