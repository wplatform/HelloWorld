package com.github.azeroth.game.scripting.interfaces.icreature;

import com.github.azeroth.game.ai.CreatureAI;
import com.github.azeroth.game.entity.creature.Creature;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface ICreatureGetAI extends IScriptObject {
    CreatureAI getAI(Creature creature);
}
