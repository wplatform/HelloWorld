package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;// Called when a player kills a creature
public interface IPlayerOnCreatureKill extends IScriptObject {
    void OnCreatureKill(Player killer, Creature killed);
}