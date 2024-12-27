package com.github.mmo.game.scripting.interfaces.iguild;

import com.github.mmo.game.guild.*;
import com.github.mmo.game.scripting.interfaces.*;

public interface IGuildOnDisband extends IScriptObject
{
	void onDisband(Guild guild);
}
