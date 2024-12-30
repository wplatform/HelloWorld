package com.github.mmo.game.scripting.interfaces.ispell;


import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.scripting.interfaces.ISpellScript;
import com.github.mmo.game.spell.SpellInfo;

public interface ISpellEnergizedBySpell extends ISpellScript {
    void energizeBySpell(Unit target, SpellInfo spellInfo, tangible.RefObject<Double> amount, Power powerType);
}
