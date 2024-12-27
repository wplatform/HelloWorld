package com.github.mmo.game.scripting.interfaces.iareatriggerentity;

import com.github.mmo.game.ai.*;
import com.github.mmo.game.entity.areatrigger.AreaTrigger;
import com.github.mmo.game.scripting.interfaces.*;

public interface IAreaTriggerEntityGetAI extends IScriptObject
{
	AreaTriggerAI getAI(AreaTrigger at);
}
