package com.github.mmo.game.scripting.interfaces.ibattlefield;

import com.github.mmo.game.battlefield.BattleField;
import com.github.mmo.game.map.Map;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IBattlefieldGetBattlefield extends IScriptObject {
    BattleField GetBattlefield(Map map);
}
