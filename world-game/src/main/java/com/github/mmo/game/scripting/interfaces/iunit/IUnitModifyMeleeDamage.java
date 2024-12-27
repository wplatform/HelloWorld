package com.github.mmo.game.scripting.interfaces.iunit;

import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.scripting.interfaces.*;

public interface IUnitModifyMeleeDamage extends IScriptObject
{
	void ModifyMeleeDamage(Unit target, Unit attacker, tangible.RefObject<Double> damage);
}
