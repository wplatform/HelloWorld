package com.github.azeroth.game.scripting.basescripts;

import com.github.azeroth.game.scripting.ScriptObject;
import com.github.azeroth.game.scripting.SpellScript;
import com.github.azeroth.game.scripting.interfaces.ispell.ISpellScriptLoaderGetSpellScript;

public class SpellScriptLoader extends ScriptObject implements ISpellScriptLoaderGetSpellScript {
    public SpellScriptLoader(String name) {
        super(name);
        global.getScriptMgr().addScript(this);
    }

    @Override
    public boolean isDatabaseBound() {
        return true;
    }

    // Should return a fully valid SpellScript.
    public SpellScript getSpellScript() {
        return null;
    }
}
