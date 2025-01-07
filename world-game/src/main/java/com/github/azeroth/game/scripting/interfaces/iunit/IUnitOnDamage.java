package com.github.azeroth.game.scripting.interfaces.iunit;

import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IUnitOnDamage extends IScriptObject {
    void OnDamage(Unit attacker, Unit victim, tangible.RefObject<Double> damage);
}
