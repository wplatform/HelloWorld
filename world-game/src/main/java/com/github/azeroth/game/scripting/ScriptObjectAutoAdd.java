package com.github.azeroth.game.scripting;

public abstract class ScriptObjectAutoAdd extends ScriptObject {
    protected ScriptObjectAutoAdd(String name) {
        super(name);
        global.getScriptMgr().addScript(this);
    }
}
