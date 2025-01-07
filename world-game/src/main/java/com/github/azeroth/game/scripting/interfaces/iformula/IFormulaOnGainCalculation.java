package com.github.azeroth.game.scripting.interfaces.iformula;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IFormulaOnGainCalculation extends IScriptObject {
    void OnGainCalculation(int gain, Player player, Unit unit);
}
