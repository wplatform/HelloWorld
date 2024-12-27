package com.github.mmo.game.scripting.interfaces.ispell;


import com.github.mmo.game.spell.*;

public interface ISpellDestinationTargetSelectHandler extends ITargetHookHandler
{
	void setDest(SpellDestination dest);
}
