package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.creature.Creature;
import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IPlayerOnPlayerKilledByCreature extends IScriptObject {
    void OnPlayerKilledByCreature(Creature killer, Player killed);
}