package com.github.azeroth.game.scripting.interfaces.iplayer;


import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.guild.Guild;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IPlayerOnChatGuild extends IScriptObject {
    void OnChat(Player player, ChatMsg type, Language lang, String msg, Guild guild);
}
