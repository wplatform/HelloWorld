package com.github.azeroth.game.scripting.interfaces.ispell;


import com.github.azeroth.game.scripting.interfaces.ISpellScript;

public interface ISpellCheckCast extends ISpellScript {
    SpellCastResult checkCast();
}
