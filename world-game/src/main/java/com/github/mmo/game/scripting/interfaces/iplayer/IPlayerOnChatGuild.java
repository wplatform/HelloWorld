package com.github.mmo.game.scripting.interfaces.iplayer;


import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.guild.Guild;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IPlayerOnChatGuild extends IScriptObject {
    void OnChat(Player player, ChatMsg type, Language lang, String msg, Guild guild);
}
