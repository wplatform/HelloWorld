package com.github.azeroth.game.scripting.interfaces.iformula;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IFormulaOnBaseGainCalculation extends IScriptObject {

    void OnBaseGainCalculation(int gain, int playerLevel, int mobLevel);
}
