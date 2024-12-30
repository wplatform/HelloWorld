package com.github.mmo.game.scripting.interfaces.ispell;

import com.github.mmo.game.scripting.interfaces.ISpellScript;
import com.github.mmo.game.spell.SpellPowerCost;

public interface ISpellOnTakePower extends ISpellScript {
    void takePower(SpellPowerCost cost);
}
