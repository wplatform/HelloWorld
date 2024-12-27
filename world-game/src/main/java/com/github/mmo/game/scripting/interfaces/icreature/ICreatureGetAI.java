package com.github.mmo.game.scripting.interfaces.icreature;

import com.github.mmo.game.ai.*;
import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.scripting.interfaces.*;

public interface ICreatureGetAI extends IScriptObject
{
	CreatureAI getAI(Creature creature);
}
