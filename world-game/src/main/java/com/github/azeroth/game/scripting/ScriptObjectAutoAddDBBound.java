package com.github.azeroth.game.scripting;

public abstract class ScriptObjectAutoAddDBBound extends ScriptObject {
    protected ScriptObjectAutoAddDBBound(String name) {
        super(name);
        global.getScriptMgr().addScript(this);
    }

    @Override
    public boolean isDatabaseBound() {
        return true;
    }
}
