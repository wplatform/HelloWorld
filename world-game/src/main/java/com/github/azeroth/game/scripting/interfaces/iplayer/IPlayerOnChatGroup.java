package com.github.azeroth.game.scripting.interfaces.iplayer;


import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.group.PlayerGroup;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IPlayerOnChatGroup extends IScriptObject {
    void OnChat(Player player, ChatMsg type, Language lang, String msg, PlayerGroup group);
}
