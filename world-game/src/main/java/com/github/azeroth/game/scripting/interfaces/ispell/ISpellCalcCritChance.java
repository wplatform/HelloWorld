package com.github.azeroth.game.scripting.interfaces.ispell;

import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.scripting.interfaces.ISpellScript;

public interface ISpellCalcCritChance extends ISpellScript {
    void calcCritChance(Unit victim, tangible.RefObject<Double> chance);
}
