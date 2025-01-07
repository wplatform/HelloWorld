package com.github.azeroth.game.scripting.interfaces.ispell;


import com.github.azeroth.game.spell.SpellDestination;

public interface ISpellDestinationTargetSelectHandler extends ITargetHookHandler {
    void setDest(SpellDestination dest);
}
