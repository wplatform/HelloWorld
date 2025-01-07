package com.github.azeroth.game.scripting.interfaces.ibattlefield;

import com.github.azeroth.game.battlefield.BattleField;
import com.github.azeroth.game.map.Map;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IBattlefieldGetBattlefield extends IScriptObject {
    BattleField GetBattlefield(Map map);
}
