package com.github.azeroth.game.scripting.interfaces.ispell;


import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.scripting.interfaces.ISpellScript;
import com.github.azeroth.game.spell.SpellInfo;

public interface ISpellEnergizedBySpell extends ISpellScript {
    void energizeBySpell(Unit target, SpellInfo spellInfo, tangible.RefObject<Double> amount, Power powerType);
}
