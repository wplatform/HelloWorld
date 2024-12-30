package com.github.mmo.game.scripting.interfaces.icondition;

import com.github.mmo.game.condition.Condition;
import com.github.mmo.game.condition.ConditionSourceInfo;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IConditionCheck extends IScriptObject {
    boolean OnConditionCheck(Condition condition, ConditionSourceInfo sourceInfo);
}
