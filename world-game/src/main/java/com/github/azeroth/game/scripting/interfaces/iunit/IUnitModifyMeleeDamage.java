package com.github.azeroth.game.scripting.interfaces.iunit;

import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IUnitModifyMeleeDamage extends IScriptObject {
    void ModifyMeleeDamage(Unit target, Unit attacker, tangible.RefObject<Double> damage);
}
