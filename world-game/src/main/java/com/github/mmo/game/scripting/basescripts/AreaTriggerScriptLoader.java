package com.github.mmo.game.scripting.basescripts;

import com.github.mmo.game.scripting.AreaTriggerScript;
import com.github.mmo.game.scripting.ScriptObject;
import com.github.mmo.game.scripting.interfaces.iareatrigger.IAreaTriggerScriptLoaderGetTriggerScriptScript;

public class AreaTriggerScriptLoader extends ScriptObject implements IAreaTriggerScriptLoaderGetTriggerScriptScript {
    public AreaTriggerScriptLoader(String name) {
        super(name);
        global.getScriptMgr().addScript(this);
    }

    @Override
    public boolean isDatabaseBound() {
        return true;
    }

    // Should return a fully valid SpellScript.
    public AreaTriggerScript getAreaTriggerScript() {
        return null;
    }
}
