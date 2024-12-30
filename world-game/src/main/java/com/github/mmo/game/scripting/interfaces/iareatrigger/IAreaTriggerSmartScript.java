package com.github.mmo.game.scripting.interfaces.iareatrigger;


import com.github.mmo.game.ai.SmartScript;
import com.github.mmo.game.ai.SmartScriptHolder;
import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.scripting.interfaces.IAreaTriggerScript;

public interface IAreaTriggerSmartScript extends IAreaTriggerScript {
    SmartScript getScript();

    default void onInitialize() {
        getScript().onInitialize(getAt());
    }

    default void onUpdate(int diff) {
        getScript().onUpdate(diff);
    }

    default void onUnitEnter(Unit unit) {
        getScript().processEventsFor(SmartEvents.AreatriggerOntrigger, unit);
    }

    default void setTimedActionList(SmartScriptHolder e, int entry, Unit invoker) {
        getScript().setTimedActionList(e, entry, invoker);
    }
}
