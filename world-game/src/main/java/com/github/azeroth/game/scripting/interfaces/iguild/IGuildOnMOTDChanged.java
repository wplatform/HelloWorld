package com.github.azeroth.game.scripting.interfaces.iguild;

import com.github.azeroth.game.guild.Guild;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IGuildOnMOTDChanged extends IScriptObject {
    void OnMOTDChanged(Guild guild, String newMotd);
}
