package com.github.mmo.game.scripting.interfaces.iformula;

import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IFormulaOnGrayLevelCalculation extends IScriptObject {
    void OnGrayLevelCalculation(int grayLevel, int playerLevel);
}
