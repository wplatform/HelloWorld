package com.github.azeroth.game.scripting.interfaces.ioutdoorpvp;

import com.github.azeroth.game.map.Map;
import com.github.azeroth.game.pvp.OutdoorPvP;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IOutdoorPvPGetOutdoorPvP extends IScriptObject {
    OutdoorPvP getOutdoorPvP(Map map);
}
