package com.github.azeroth.game.scripting.basescripts;

import com.github.azeroth.game.scripting.AuraScript;
import com.github.azeroth.game.scripting.ScriptObject;
import com.github.azeroth.game.scripting.interfaces.iaura.IAuraScriptLoaderGetAuraScript;

public class AuraScriptLoader extends ScriptObject implements IAuraScriptLoaderGetAuraScript {
    public AuraScriptLoader(String name) {
        super(name);
        global.getScriptMgr().addScript(this);
    }

    @Override
    public boolean isDatabaseBound() {
        return true;
    }

    // Should return a fully valid AuraScript.
    public AuraScript getAuraScript() {
        return null;
    }
}
