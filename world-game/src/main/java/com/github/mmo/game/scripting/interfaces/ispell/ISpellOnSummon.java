package com.github.mmo.game.scripting.interfaces.ispell;

import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.scripting.interfaces.ISpellScript;

public interface ISpellOnSummon extends ISpellScript {
    void OnSummon(Creature creature);
}
