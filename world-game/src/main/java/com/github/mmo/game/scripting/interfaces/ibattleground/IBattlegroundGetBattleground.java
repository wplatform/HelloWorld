package com.github.mmo.game.scripting.interfaces.ibattleground;

import com.github.mmo.game.battleground.Battleground;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IBattlegroundGetBattleground extends IScriptObject {
    Battleground getBattleground();
}
