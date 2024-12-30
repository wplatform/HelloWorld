package com.github.mmo.game.scripting.interfaces.ioutdoorpvp;

import com.github.mmo.game.map.Map;
import com.github.mmo.game.pvp.OutdoorPvP;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IOutdoorPvPGetOutdoorPvP extends IScriptObject {
    OutdoorPvP getOutdoorPvP(Map map);
}
