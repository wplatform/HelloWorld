package com.github.mmo.game.scripting.basescripts;

import com.github.mmo.game.ai.GameObjectAI;
import com.github.mmo.game.entity.gobject.GameObject;
import com.github.mmo.game.scripting.ScriptObjectAutoAddDBBound;
import com.github.mmo.game.scripting.interfaces.igameobject.IGameObjectGetAI;

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
