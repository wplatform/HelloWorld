package com.github.azeroth.game.scripting.interfaces.iaura;

import com.github.azeroth.game.scripting.interfaces.IAuraScript;

public interface IAuraEnterLeaveCombat extends IAuraScript {
    void EnterLeaveCombat(boolean isNowInCombat);
}
