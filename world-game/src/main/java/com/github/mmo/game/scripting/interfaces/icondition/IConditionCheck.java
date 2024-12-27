package com.github.mmo.game.scripting.interfaces.icondition;

import com.github.mmo.game.condition.*;
import com.github.mmo.game.scripting.interfaces.*;

public interface IConditionCheck extends IScriptObject
{
	boolean OnConditionCheck(Condition condition, ConditionSourceInfo sourceInfo);
}
