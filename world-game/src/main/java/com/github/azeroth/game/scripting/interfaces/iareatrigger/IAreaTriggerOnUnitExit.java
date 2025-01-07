package com.github.azeroth.game.scripting.interfaces.iareatrigger;

import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.scripting.interfaces.IAreaTriggerScript;

public interface IAreaTriggerOnUnitExit extends IAreaTriggerScript {
    void onUnitExit(Unit unit);
}
