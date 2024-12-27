package com.github.mmo.game.scripting.interfaces.iformula;

import com.github.mmo.game.scripting.interfaces.*;public interface IFormulaOnGroupRateCaclulation extends IScriptObject {

    void OnGroupRateCalculation(double rate, int count, boolean isRaid);
}
