package com.github.mmo.game.scripting.interfaces.iguild;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.guild.Guild;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IGuildOnCreate extends IScriptObject {
    void onCreate(Guild guild, Player leader, String name);
}
