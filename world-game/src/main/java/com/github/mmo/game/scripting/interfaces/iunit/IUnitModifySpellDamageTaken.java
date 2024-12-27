package com.github.mmo.game.scripting.interfaces.iunit;

import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.spell.*;
import com.github.mmo.game.scripting.interfaces.*;

public interface IUnitModifySpellDamageTaken extends IScriptObject
{
	void ModifySpellDamageTaken(Unit target, Unit attacker, tangible.RefObject<Double> damage, SpellInfo spellInfo);
}
