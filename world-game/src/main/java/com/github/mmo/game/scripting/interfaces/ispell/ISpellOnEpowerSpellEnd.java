package com.github.mmo.game.scripting.interfaces.ispell;


import com.github.mmo.game.scripting.interfaces.ISpellScript;

public interface ISpellOnEpowerSpellEnd extends ISpellScript {
    void EmpowerSpellEnd(SpellEmpowerStageRecord stage, int stageDelta);
}
