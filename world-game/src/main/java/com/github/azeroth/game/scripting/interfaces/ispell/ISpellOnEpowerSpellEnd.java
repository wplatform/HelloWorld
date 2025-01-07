package com.github.azeroth.game.scripting.interfaces.ispell;


import com.github.azeroth.game.scripting.interfaces.ISpellScript;

public interface ISpellOnEpowerSpellEnd extends ISpellScript {
    void EmpowerSpellEnd(SpellEmpowerStageRecord stage, int stageDelta);
}
