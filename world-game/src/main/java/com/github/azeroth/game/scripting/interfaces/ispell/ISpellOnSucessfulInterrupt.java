package com.github.azeroth.game.scripting.interfaces.ispell;

import com.github.azeroth.game.scripting.interfaces.ISpellScript;
import com.github.azeroth.game.spell.Spell;

public interface ISpellOnSucessfulInterrupt extends ISpellScript {
    void SucessfullyInterrupted(Spell spellInterrupted);
}
