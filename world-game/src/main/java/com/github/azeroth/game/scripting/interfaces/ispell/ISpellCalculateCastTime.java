package com.github.azeroth.game.scripting.interfaces.ispell;

import com.github.azeroth.game.scripting.interfaces.ISpellScript;

public interface ISpellCalculateCastTime extends ISpellScript {
    int calcCastTime(int castTime);
}
