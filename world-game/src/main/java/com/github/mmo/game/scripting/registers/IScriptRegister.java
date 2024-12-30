package com.github.mmo.game.scripting.registers;

import com.github.mmo.game.scripting.ScriptAttribute;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IScriptRegister {
    Class getAttributeType();

    void register(ScriptAttribute attribute, IScriptObject script, String scriptName);
}
