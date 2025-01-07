package com.github.azeroth.game.scripting.interfaces.iunit;

import com.github.azeroth.game.entity.unit.HealInfo;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IUnitOnHeal extends IScriptObject {
    void OnHeal(HealInfo healInfo, tangible.RefObject<Integer> gain);
}
