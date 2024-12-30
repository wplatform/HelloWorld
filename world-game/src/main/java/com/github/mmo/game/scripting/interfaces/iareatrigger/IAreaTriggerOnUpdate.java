package com.github.mmo.game.scripting.interfaces.iareatrigger;

import com.github.mmo.game.scripting.interfaces.IAreaTriggerScript;

public interface IAreaTriggerOnUpdate extends IAreaTriggerScript {
    void onUpdate(int diff);
}
