package com.github.mmo.game.scripting.interfaces.ispell;

import com.github.mmo.game.scripting.interfaces.ISpellScript;
import com.github.mmo.game.spell.Spell;

public interface ISpellOnSucessfulInterrupt extends ISpellScript {
    void SucessfullyInterrupted(Spell spellInterrupted);
}
