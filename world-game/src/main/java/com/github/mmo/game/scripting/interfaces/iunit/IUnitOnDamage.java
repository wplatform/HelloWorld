package com.github.mmo.game.scripting.interfaces.iunit;

import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IUnitOnDamage extends IScriptObject {
    void OnDamage(Unit attacker, Unit victim, tangible.RefObject<Double> damage);
}
