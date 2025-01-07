package com.github.azeroth.game.scripting.interfaces.itransport;

import com.github.azeroth.game.entity.creature.Creature;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface ITransportOnAddCreaturePassenger extends IScriptObject {
    void OnAddCreaturePassenger(Transport transport, Creature creature);
}
