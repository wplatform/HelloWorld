package com.github.azeroth.game.scripting.interfaces.iguild;

import com.github.azeroth.game.guild.Guild;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IGuildOnDisband extends IScriptObject {
    void onDisband(Guild guild);
}
