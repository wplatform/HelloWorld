package com.github.mmo.game.scripting.interfaces.imap;

import com.github.mmo.game.map.InstanceMap;
import com.github.mmo.game.map.InstanceScript;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IInstanceMapGetInstanceScript extends IScriptObject {
    InstanceScript GetInstanceScript(InstanceMap map);
}
