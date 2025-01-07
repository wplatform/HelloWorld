package com.github.azeroth.game.scripting.interfaces.imap;

import com.github.azeroth.game.map.InstanceMap;
import com.github.azeroth.game.map.InstanceScript;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IInstanceMapGetInstanceScript extends IScriptObject {
    InstanceScript GetInstanceScript(InstanceMap map);
}
