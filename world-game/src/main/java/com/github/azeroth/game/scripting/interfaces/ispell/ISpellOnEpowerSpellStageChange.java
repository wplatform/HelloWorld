package com.github.azeroth.game.scripting.interfaces.ispell;


import com.github.azeroth.game.scripting.interfaces.ISpellScript;

public interface ISpellOnEpowerSpellStageChange extends ISpellScript {
    void EmpowerSpellStageChange(SpellEmpowerStageRecord oldStage, SpellEmpowerStageRecord newStage);
}
