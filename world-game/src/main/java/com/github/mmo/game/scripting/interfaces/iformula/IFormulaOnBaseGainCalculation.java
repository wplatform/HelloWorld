package com.github.mmo.game.scripting.interfaces.iformula;

import com.github.mmo.game.scripting.interfaces.*;public interface IFormulaOnBaseGainCalculation extends IScriptObject {

    void OnBaseGainCalculation(int gain, int playerLevel, int mobLevel);
}
