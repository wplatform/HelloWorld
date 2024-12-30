package com.github.mmo.game.spell;


// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
public class AuraEffectHandlerAttribute extends Attribute {
    public AuraEffectHandlerAttribute(AuraType type) {
        setAuraType(type);
    }    private auraType auraType = getAuraType().values()[0];

    public final AuraType getAuraType() {
        return auraType;
    }

    public final void setAuraType(AuraType value) {
        auraType = value;
    }


}
