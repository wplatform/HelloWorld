package com.github.mmo.game.scripting.interfaces.ispell;

import com.github.mmo.game.spell.*;
import com.github.mmo.game.scripting.interfaces.*;public interface ISpellOnTakePower extends ISpellScript {
    void takePower(SpellPowerCost cost);
}
