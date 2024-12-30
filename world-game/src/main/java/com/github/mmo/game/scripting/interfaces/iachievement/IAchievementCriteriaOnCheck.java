package com.github.mmo.game.scripting.interfaces.iachievement;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IAchievementCriteriaOnCheck extends IScriptObject {
    boolean OnCheck(Player source, Unit target);
}
