package com.github.azeroth.game.scripting.interfaces.icondition;

import com.github.azeroth.game.condition.Condition;
import com.github.azeroth.game.condition.ConditionSourceInfo;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IConditionCheck extends IScriptObject {
    boolean OnConditionCheck(Condition condition, ConditionSourceInfo sourceInfo);
}
