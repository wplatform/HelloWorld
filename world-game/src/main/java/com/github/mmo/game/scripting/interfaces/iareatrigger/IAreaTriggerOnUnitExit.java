package com.github.mmo.game.scripting.interfaces.iareatrigger;

import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.scripting.interfaces.IAreaTriggerScript;

public interface IAreaTriggerOnUnitExit extends IAreaTriggerScript {
    void onUnitExit(Unit unit);
}
