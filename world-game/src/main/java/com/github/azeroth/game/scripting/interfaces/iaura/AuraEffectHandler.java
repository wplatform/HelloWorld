package com.github.azeroth.game.scripting.interfaces.iaura;


public class AuraEffectHandler implements IAuraEffectHandler {
    private int effectIndex;
    private AuraScripthookType hookType = AuraScriptHookType.values()[0];

    public AuraEffectHandler(int effectIndex, AuraType auraType, AuraScriptHookType hookType) {
        setEffectIndex(effectIndex);
        setAuraType(auraType);
        setHookType(hookType);
    }

    public final int getEffectIndex() {
        return effectIndex;
    }    private auraType auraType = getAuraType().values()[0];

    private void setEffectIndex(int value) {
        effectIndex = value;
    }

    public final AuraType getAuraType() {
        return auraType;
    }

    private void setAuraType(AuraType value) {
        auraType = value;
    }

    public final AuraScriptHookType getHookType() {
        return hookType;
    }

    private void setHookType(AuraScriptHookType value) {
        hookType = value;
    }


}
