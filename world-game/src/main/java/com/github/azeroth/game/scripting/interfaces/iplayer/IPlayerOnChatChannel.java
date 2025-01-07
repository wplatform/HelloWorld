package com.github.azeroth.game.scripting.interfaces.iplayer;


import com.github.azeroth.game.chat.Channel;
import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IPlayerOnChatChannel extends IScriptObject {
    void OnChat(Player player, ChatMsg type, Language lang, String msg, Channel channel);
}
