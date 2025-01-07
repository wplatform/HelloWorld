package com.github.azeroth.game.scripting.basescripts;

import com.github.azeroth.game.ai.AreaTriggerAI;
import com.github.azeroth.game.entity.areatrigger.AreaTrigger;
import com.github.azeroth.game.scripting.ScriptObjectAutoAddDBBound;
import com.github.azeroth.game.scripting.interfaces.iareatriggerentity.IAreaTriggerEntityGetAI;

public class GenericAreaTriggerScript<AI extends AreaTriggerAI> extends ScriptObjectAutoAddDBBound implements IAreaTriggerEntityGetAI {
    private final Object[] args;

    public GenericAreaTriggerScript(String name, Object[] args) {
        super(name);
        args = args;
    }

    public final AreaTriggerAI getAI(AreaTrigger me) {
        if (me.getInstanceScript() != null) {
            return GenericAreaTriggerScript.<AI>GetInstanceAI(me);
        } else {
            return (AI) system.Activator.CreateInstance(ai.class, new Object[]{me}.Combine(args));
        }
    }
}
