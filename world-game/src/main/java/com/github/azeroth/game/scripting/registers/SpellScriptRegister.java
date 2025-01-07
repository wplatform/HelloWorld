package com.github.azeroth.game.scripting.registers;

import com.github.azeroth.game.scripting.ScriptAttribute;
import com.github.azeroth.game.scripting.SpellScriptAttribute;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public class SpellScriptRegister implements IScriptRegister {
    public final Class getAttributeType() {
        return SpellScriptAttribute.class;
    }

    public final void register(ScriptAttribute attribute, IScriptObject script, String scriptName) {
        if (attribute instanceof SpellScriptAttribute spellScript && spellScript.getSpellIds() != null) {
            for (var id : spellScript.getSpellIds()) {
                global.getObjectMgr().registerSpellScript(id, scriptName, spellScript.getAllRanks());
            }
        }
    }
}
