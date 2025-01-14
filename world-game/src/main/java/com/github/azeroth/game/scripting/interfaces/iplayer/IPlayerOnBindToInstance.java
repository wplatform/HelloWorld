package com.github.azeroth.game.scripting.interfaces.iplayer;


import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

// Called when a player is bound to an instance
public interface IPlayerOnBindToInstance extends IScriptObject {
    void OnBindToInstance(Player player, Difficulty difficulty, int mapId, boolean permanent, byte extendState);
}
