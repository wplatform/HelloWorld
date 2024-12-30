package com.github.mmo.game.scripting.basescripts;

import com.github.mmo.game.map.Map;

public class WorldMapScript extends MapScript<Map> {
    public WorldMapScript(String name, int mapId) {
        super(name, mapId);
        if (getEntry() != null && !getEntry().IsWorldMap()) {
            Log.outError(LogFilter.Scripts, "WorldMapScript for map {0} is invalid.", mapId);
        }

        global.getScriptMgr().addScript(this);
    }
}
