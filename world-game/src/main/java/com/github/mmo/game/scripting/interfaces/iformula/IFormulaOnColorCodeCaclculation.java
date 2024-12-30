package com.github.mmo.game.scripting.interfaces.iformula;


import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IFormulaOnColorCodeCaclculation extends IScriptObject {

    void OnColorCodeCalculation(XPColorChar color, int playerLevel, int mobLevel);
}
