package com.github.azeroth.game.scripting.interfaces.iplayer;


import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

// The following methods are called when a player sends a chat message.
public interface IPlayerOnChat extends IScriptObject {
    void OnChat(Player player, ChatMsg type, Language lang, String msg);
}
