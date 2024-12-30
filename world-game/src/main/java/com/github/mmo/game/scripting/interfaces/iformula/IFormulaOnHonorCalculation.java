package com.github.mmo.game.scripting.interfaces.iformula;

import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IFormulaOnHonorCalculation extends IScriptObject {
    void OnHonorCalculation(double honor, int level, double multiplier);
}
