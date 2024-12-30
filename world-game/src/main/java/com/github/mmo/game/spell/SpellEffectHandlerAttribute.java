package com.github.mmo.game.spell;


// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
public class SpellEffectHandlerAttribute extends Attribute {
    private SpelleffectName effectName = SpellEffectName.values()[0];

    public SpellEffectHandlerAttribute(SpellEffectName effectName) {
        setEffectName(effectName);
    }

    public final SpellEffectName getEffectName() {
        return effectName;
    }

    public final void setEffectName(SpellEffectName value) {
        effectName = value;
    }
}
