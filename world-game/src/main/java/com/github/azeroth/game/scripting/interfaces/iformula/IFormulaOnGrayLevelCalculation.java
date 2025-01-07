package com.github.azeroth.game.scripting.interfaces.iformula;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IFormulaOnGrayLevelCalculation extends IScriptObject {
    void OnGrayLevelCalculation(int grayLevel, int playerLevel);
}
