package com.github.mmo.game.scripting.interfaces.iareatrigger;

import com.github.mmo.game.scripting.interfaces.IAreaTriggerScript;

import java.util.HashMap;


public interface IAreaTriggerScriptValues extends IAreaTriggerScript {
    HashMap<String, object> getScriptValues();
}
