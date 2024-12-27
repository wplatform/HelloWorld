package com.github.mmo.game.scripting.interfaces.iplayer;


import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;

public interface IPlayerOnChatWhisper extends IScriptObject
{
	void OnChat(Player player, ChatMsg type, Language lang, String msg, Player receiver);
}
