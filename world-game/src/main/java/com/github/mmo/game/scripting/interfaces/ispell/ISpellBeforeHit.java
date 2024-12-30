package com.github.mmo.game.scripting.interfaces.ispell;


import com.github.mmo.game.scripting.interfaces.ISpellScript;

public interface ISpellBeforeHit extends ISpellScript {
    void BeforeHit(SpellMissInfo missInfo);
}
