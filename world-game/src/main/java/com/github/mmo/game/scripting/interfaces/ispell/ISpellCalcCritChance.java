package com.github.mmo.game.scripting.interfaces.ispell;

import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.scripting.interfaces.ISpellScript;

public interface ISpellCalcCritChance extends ISpellScript {
    void calcCritChance(Unit victim, tangible.RefObject<Double> chance);
}
