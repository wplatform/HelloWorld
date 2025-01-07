package com.github.azeroth.game.scripting.interfaces.ibattleground;

import com.github.azeroth.game.battleground.Battleground;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IBattlegroundGetBattleground extends IScriptObject {
    Battleground getBattleground();
}
