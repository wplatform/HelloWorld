package com.github.mmo.game.scripting.interfaces.ibattlefield;

import com.github.mmo.game.battlefield.*;
import com.github.mmo.game.map.*;
import com.github.mmo.game.scripting.interfaces.*;public interface IBattlefieldGetBattlefield extends IScriptObject {
    BattleField GetBattlefield(Map map);
}
