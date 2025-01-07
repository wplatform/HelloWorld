package com.github.azeroth.game.scripting.interfaces.ispell;

import com.github.azeroth.game.entity.creature.Creature;
import com.github.azeroth.game.scripting.interfaces.ISpellScript;

public interface ISpellOnSummon extends ISpellScript {
    void OnSummon(Creature creature);
}
