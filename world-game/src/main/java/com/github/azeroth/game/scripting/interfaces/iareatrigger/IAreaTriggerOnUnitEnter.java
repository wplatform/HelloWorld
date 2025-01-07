package com.github.azeroth.game.scripting.interfaces.iareatrigger;

import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.scripting.interfaces.IAreaTriggerScript;

public interface IAreaTriggerOnUnitEnter extends IAreaTriggerScript {
    void onUnitEnter(Unit unit);
}
