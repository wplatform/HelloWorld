package com.github.mmo.game.scripting.interfaces.iplayer;


import com.github.mmo.game.chat.Channel;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IPlayerOnChatChannel extends IScriptObject {
    void OnChat(Player player, ChatMsg type, Language lang, String msg, Channel channel);
}
