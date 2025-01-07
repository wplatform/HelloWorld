package com.github.azeroth.game.scripting.interfaces.iformula;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IFormulaOnZeroDifference extends IScriptObject {
    void OnZeroDifferenceCalculation(int diff, int playerLevel);
}
