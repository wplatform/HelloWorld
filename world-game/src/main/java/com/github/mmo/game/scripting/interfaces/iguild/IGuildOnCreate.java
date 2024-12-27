package com.github.mmo.game.scripting.interfaces.iguild;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.guild.*;
import com.github.mmo.game.scripting.interfaces.*;public interface IGuildOnCreate extends IScriptObject {
    void onCreate(Guild guild, Player leader, String name);
}
