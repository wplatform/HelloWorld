package com.github.mmo.game.scripting.interfaces.iplayer;


import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;

// The following methods are called when a player sends a chat message.
public interface IPlayerOnChat extends IScriptObject
{
	void OnChat(Player player, ChatMsg type, Language lang, String msg);
}
