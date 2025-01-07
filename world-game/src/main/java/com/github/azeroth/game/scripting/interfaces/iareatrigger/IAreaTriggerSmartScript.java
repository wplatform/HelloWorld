package com.github.azeroth.game.scripting.interfaces.iareatrigger;


import com.github.azeroth.game.ai.SmartScript;
import com.github.azeroth.game.ai.SmartScriptHolder;
import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.scripting.interfaces.IAreaTriggerScript;

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
