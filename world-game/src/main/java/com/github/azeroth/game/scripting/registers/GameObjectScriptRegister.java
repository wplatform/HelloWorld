package com.github.azeroth.game.scripting.registers;

import com.github.azeroth.game.scripting.GameObjectScriptAttribute;
import com.github.azeroth.game.scripting.ScriptAttribute;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public class GameObjectScriptRegister implements IScriptRegister {
    public final Class getAttributeType() {
        return GameObjectScriptAttribute.class;
    }

    public final void register(ScriptAttribute attribute, IScriptObject script, String scriptName) {
        if (attribute instanceof GameObjectScriptAttribute gameObjectScript && gameObjectScript.getGameObjectIds() != null) {
            for (var id : gameObjectScript.getGameObjectIds()) {
                var gameObject = global.getObjectMgr().getGameObjectTemplate(id);

                if (gameObject == null) {
                    Log.outError(LogFilter.Scripts, String.format("GameObjectScriptAttribute: Unknown game object id %1$s for script name %2$s", id, scriptName));

                    continue;
                }

                if (gameObject.scriptId == 0) // dont override database
                {
                    gameObject.scriptId = global.getObjectMgr().getScriptId(scriptName);
                }
            }
        }
    }
}
