package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IPlayerOnPlayerKilledByCreature extends IScriptObject {
    void OnPlayerKilledByCreature(Creature killer, Player killed);
}
