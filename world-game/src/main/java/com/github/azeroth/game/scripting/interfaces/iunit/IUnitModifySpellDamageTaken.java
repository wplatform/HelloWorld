package com.github.azeroth.game.scripting.interfaces.iunit;

import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;
import com.github.azeroth.game.spell.SpellInfo;

public interface IUnitModifySpellDamageTaken extends IScriptObject {
    void ModifySpellDamageTaken(Unit target, Unit attacker, tangible.RefObject<Double> damage, SpellInfo spellInfo);
}
