package com.github.azeroth.game.scripting.interfaces.iareatrigger;

import com.github.azeroth.game.scripting.interfaces.IAreaTriggerScript;

import java.util.HashMap;


public interface IAreaTriggerScriptValues extends IAreaTriggerScript {
    HashMap<String, object> getScriptValues();
}
