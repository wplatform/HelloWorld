package com.github.mmo.game.scripting.interfaces.iunit;

import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.scripting.interfaces.*;

public interface IUnitModifyPeriodicDamageAurasTick extends IScriptObject
{
	void ModifyPeriodicDamageAurasTick(Unit target, Unit attacker, tangible.RefObject<Double> damage);
}