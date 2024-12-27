package com.github.mmo.game.scripting.interfaces.ioutdoorpvp;

import com.github.mmo.game.map.*;
import com.github.mmo.game.pvp.*;
import com.github.mmo.game.scripting.interfaces.*;

public interface IOutdoorPvPGetOutdoorPvP extends IScriptObject
{
	OutdoorPvP getOutdoorPvP(Map map);
}
