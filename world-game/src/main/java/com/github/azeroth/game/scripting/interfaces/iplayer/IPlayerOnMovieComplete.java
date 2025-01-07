package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

// Called when a player completes a movie
public interface IPlayerOnMovieComplete extends IScriptObject {
    void OnMovieComplete(Player player, int movieId);
}
