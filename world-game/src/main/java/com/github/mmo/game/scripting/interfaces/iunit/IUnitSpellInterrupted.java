package com.github.mmo.game.scripting.interfaces.iunit;

import com.github.mmo.game.spell.*;
import com.github.mmo.game.scripting.interfaces.*;

public interface IUnitSpellInterrupted extends IScriptObject
{
	void spellInterrupted(Spell spellInterrupted, Spell interruptedBy);
}
