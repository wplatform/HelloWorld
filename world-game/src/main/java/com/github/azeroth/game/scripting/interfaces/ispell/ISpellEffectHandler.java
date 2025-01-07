package com.github.azeroth.game.scripting.interfaces.ispell;


public interface ISpellEffectHandler extends ISpellEffect {
    SpellEffectName getEffectName();

    void callEffect(int effIndex);
}
