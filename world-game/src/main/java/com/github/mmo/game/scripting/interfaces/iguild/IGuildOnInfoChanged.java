package com.github.mmo.game.scripting.interfaces.iguild;

import com.github.mmo.game.guild.Guild;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IGuildOnInfoChanged extends IScriptObject {
    void OnInfoChanged(Guild guild, String newInfo);
}
