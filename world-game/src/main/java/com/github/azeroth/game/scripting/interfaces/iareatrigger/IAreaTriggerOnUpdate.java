package com.github.azeroth.game.scripting.interfaces.iareatrigger;

import com.github.azeroth.game.scripting.interfaces.IAreaTriggerScript;

public interface IAreaTriggerOnUpdate extends IAreaTriggerScript {
    void onUpdate(int diff);
}
