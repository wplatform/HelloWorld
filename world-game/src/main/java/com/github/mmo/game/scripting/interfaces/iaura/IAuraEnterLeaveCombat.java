package com.github.mmo.game.scripting.interfaces.iaura;

import com.github.mmo.game.scripting.interfaces.IAuraScript;

public interface IAuraEnterLeaveCombat extends IAuraScript {
    void EnterLeaveCombat(boolean isNowInCombat);
}
