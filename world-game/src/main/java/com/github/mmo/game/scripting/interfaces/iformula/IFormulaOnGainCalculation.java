package com.github.mmo.game.scripting.interfaces.iformula;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.scripting.interfaces.*;

public interface IFormulaOnGainCalculation extends IScriptObject
{
	void OnGainCalculation(int gain, Player player, Unit unit);
}
