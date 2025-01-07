package com.github.azeroth.game.scripting.interfaces.ispell;

import com.github.azeroth.game.scripting.interfaces.ISpellScript;
import com.github.azeroth.game.spell.SpellPowerCost;

public interface ISpellOnTakePower extends ISpellScript {
    void takePower(SpellPowerCost cost);
}
