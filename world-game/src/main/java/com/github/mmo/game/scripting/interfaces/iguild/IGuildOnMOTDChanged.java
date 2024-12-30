package com.github.mmo.game.scripting.interfaces.iguild;

import com.github.mmo.game.guild.Guild;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IGuildOnMOTDChanged extends IScriptObject {
    void OnMOTDChanged(Guild guild, String newMotd);
}
