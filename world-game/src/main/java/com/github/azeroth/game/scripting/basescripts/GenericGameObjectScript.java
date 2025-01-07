package com.github.azeroth.game.scripting.basescripts;

import com.github.azeroth.game.ai.GameObjectAI;
import com.github.azeroth.game.entity.gobject.GameObject;
import com.github.azeroth.game.scripting.ScriptObjectAutoAddDBBound;
import com.github.azeroth.game.scripting.interfaces.igameobject.IGameObjectGetAI;

public class GenericGameObjectScript<AI extends GameObjectAI> extends ScriptObjectAutoAddDBBound implements IGameObjectGetAI {
    private final Object[] args;

    public GenericGameObjectScript(String name, Object[] args) {
        super(name);
        args = args;
    }

    public final GameObjectAI getAI(GameObject me) {
        if (me.getInstanceScript() != null) {
            return GenericGameObjectScript.<AI>GetInstanceAI(me);
        } else {
            return (AI) system.Activator.CreateInstance(ai.class, new Object[]{me}.Combine(args));
        }
    }
}
