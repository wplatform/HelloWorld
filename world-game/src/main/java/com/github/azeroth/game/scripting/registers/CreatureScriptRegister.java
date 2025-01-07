package com.github.azeroth.game.scripting.registers;

import com.github.azeroth.game.scripting.CreatureScriptAttribute;
import com.github.azeroth.game.scripting.ScriptAttribute;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public class CreatureScriptRegister implements IScriptRegister {
    public final Class getAttributeType() {
        return CreatureScriptAttribute.class;
    }

    public final void register(ScriptAttribute attribute, IScriptObject script, String scriptName) {
        if (attribute instanceof CreatureScriptAttribute creatureScript && creatureScript.getCreatureIds() != null) {
            for (var id : creatureScript.getCreatureIds()) {
                var creatureTemplate = global.getObjectMgr().getCreatureTemplate(id);

                if (creatureTemplate == null) {
                    Log.outError(LogFilter.Scripts, String.format("CreatureScriptAttribute: Unknown creature id %1$s for script name %2$s", id, scriptName));

                    continue;
                }

                if (creatureTemplate.scriptID == 0) // dont override database
                {
                    creatureTemplate.scriptID = global.getObjectMgr().getScriptId(scriptName);
                }
            }
        }
    }
}
