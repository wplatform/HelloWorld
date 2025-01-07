package com.github.azeroth.game.scripting.interfaces.iformula;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IFormulaOnHonorCalculation extends IScriptObject {
    void OnHonorCalculation(double honor, int level, double multiplier);
}
