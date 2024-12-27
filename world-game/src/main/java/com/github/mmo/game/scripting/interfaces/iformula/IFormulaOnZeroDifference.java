package com.github.mmo.game.scripting.interfaces.iformula;

import com.github.mmo.game.scripting.interfaces.*;
public interface IFormulaOnZeroDifference extends IScriptObject
{
	void OnZeroDifferenceCalculation(int diff, int playerLevel);
}
