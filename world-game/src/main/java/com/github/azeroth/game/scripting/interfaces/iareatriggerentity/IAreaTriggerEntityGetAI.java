package com.github.azeroth.game.scripting.interfaces.iareatriggerentity;

import com.github.azeroth.game.ai.AreaTriggerAI;
import com.github.azeroth.game.entity.areatrigger.AreaTrigger;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IAreaTriggerEntityGetAI extends IScriptObject {
    AreaTriggerAI getAI(AreaTrigger at);
}
