package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;

// Called when a player completes a movie
public interface IPlayerOnMovieComplete extends IScriptObject
{
	void OnMovieComplete(Player player, int movieId);
}
