package com.github.azeroth.game.scripting.interfaces.ispell;


import com.github.azeroth.game.scripting.interfaces.ISpellScript;

public interface ISpellBeforeHit extends ISpellScript {
    void BeforeHit(SpellMissInfo missInfo);
}
