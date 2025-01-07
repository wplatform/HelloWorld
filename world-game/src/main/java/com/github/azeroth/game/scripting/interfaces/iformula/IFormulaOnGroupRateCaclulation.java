package com.github.azeroth.game.scripting.interfaces.iformula;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IFormulaOnGroupRateCaclulation extends IScriptObject {

    void OnGroupRateCalculation(double rate, int count, boolean isRaid);
}
