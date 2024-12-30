package com.github.mmo.game.scripting.interfaces.itransport;

import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface ITransportOnAddCreaturePassenger extends IScriptObject {
    void OnAddCreaturePassenger(Transport transport, Creature creature);
}
