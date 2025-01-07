package com.github.azeroth.game.scripting.registers;

import com.github.azeroth.game.scripting.ScriptAttribute;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IScriptRegister {
    Class getAttributeType();

    void register(ScriptAttribute attribute, IScriptObject script, String scriptName);
}
