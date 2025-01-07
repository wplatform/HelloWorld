package com.github.azeroth.game.scripting.interfaces.iguild;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.guild.Guild;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IGuildOnCreate extends IScriptObject {
    void onCreate(Guild guild, Player leader, String name);
}
