package com.github.mmo.game.scripting.interfaces.iguild;

import com.github.mmo.game.guild.*;
import com.github.mmo.game.scripting.interfaces.*;

public interface IGuildOnMOTDChanged extends IScriptObject
{
	void OnMOTDChanged(Guild guild, String newMotd);
}
