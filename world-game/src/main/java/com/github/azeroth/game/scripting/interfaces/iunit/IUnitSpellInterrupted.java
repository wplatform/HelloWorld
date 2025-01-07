package com.github.azeroth.game.scripting.interfaces.iunit;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;
import com.github.azeroth.game.spell.Spell;

public interface IUnitSpellInterrupted extends IScriptObject {
    void spellInterrupted(Spell spellInterrupted, Spell interruptedBy);
}
