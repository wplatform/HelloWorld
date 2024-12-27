package com.github.mmo.game.scripting.interfaces.igroup;

import com.github.mmo.game.group.*;
import com.github.mmo.game.scripting.interfaces.*;

public interface IGroupOnDisband extends IScriptObject
{
	void onDisband(PlayerGroup group);
}
