package com.github.azeroth.game.scripting.interfaces.iformula;


import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IFormulaOnColorCodeCaclculation extends IScriptObject {

    void OnColorCodeCalculation(XPColorChar color, int playerLevel, int mobLevel);
}
