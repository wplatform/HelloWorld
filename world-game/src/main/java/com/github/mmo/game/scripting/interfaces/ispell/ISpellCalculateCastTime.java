package com.github.mmo.game.scripting.interfaces.ispell;

import com.github.mmo.game.scripting.interfaces.ISpellScript;

public interface ISpellCalculateCastTime extends ISpellScript {
    int calcCastTime(int castTime);
}
