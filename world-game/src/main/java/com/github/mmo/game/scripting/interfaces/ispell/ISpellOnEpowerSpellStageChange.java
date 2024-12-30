package com.github.mmo.game.scripting.interfaces.ispell;


import com.github.mmo.game.scripting.interfaces.ISpellScript;

public interface ISpellOnEpowerSpellStageChange extends ISpellScript {
    void EmpowerSpellStageChange(SpellEmpowerStageRecord oldStage, SpellEmpowerStageRecord newStage);
}
