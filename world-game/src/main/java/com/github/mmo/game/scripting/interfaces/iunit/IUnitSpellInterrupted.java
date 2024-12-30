package com.github.mmo.game.scripting.interfaces.iunit;

import com.github.mmo.game.scripting.interfaces.IScriptObject;
import com.github.mmo.game.spell.Spell;

public interface IUnitSpellInterrupted extends IScriptObject {
    void spellInterrupted(Spell spellInterrupted, Spell interruptedBy);
}
