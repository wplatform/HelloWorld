package com.github.mmo.game.scripting.interfaces.iaura;


public interface IAuraEffectHandler {
    int getEffectIndex();

    AuraType getAuraType();

    AuraScriptHookType getHookType();
}
