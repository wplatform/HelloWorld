package com.github.mmo.game.scripting.basescripts;

import com.github.mmo.game.ai.CreatureAI;
import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.scripting.ScriptObjectAutoAddDBBound;
import com.github.mmo.game.scripting.interfaces.icreature.ICreatureGetAI;

public class GenericCreatureScript<AI extends CreatureAI> extends ScriptObjectAutoAddDBBound implements ICreatureGetAI {
    private final Object[] args;

    public GenericCreatureScript(String name, Object[] args) {
        super(name);
        args = args;
    }

    public CreatureAI getAI(Creature me) {
        if (me.getInstanceScript() != null) {
            return GenericCreatureScript.<AI>GetInstanceAI(me);
        } else {
            return (AI) system.Activator.CreateInstance(ai.class, new Object[]{me}.Combine(args));
        }
    }
}
