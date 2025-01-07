package com.github.azeroth.game.scripting.interfaces.iachievement;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IAchievementCriteriaOnCheck extends IScriptObject {
    boolean OnCheck(Player source, Unit target);
}
