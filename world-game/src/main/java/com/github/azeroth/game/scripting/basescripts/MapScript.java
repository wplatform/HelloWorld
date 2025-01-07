package com.github.azeroth.game.scripting.basescripts;


import com.github.azeroth.dbc.domain.MapEntry;
import com.github.azeroth.game.map.Map;
import com.github.azeroth.game.scripting.ScriptObject;

public class MapScript<T extends Map> extends ScriptObject {
    private final MapEntry mapEntry;

    public MapScript(String name, int mapId) {
        super(name);
        mapEntry = CliDB.MapStorage.get(mapId);

        if (mapEntry == null) {
            Log.outError(LogFilter.Scripts, "Invalid MapScript for {0}; no such map ID.", mapId);
        }
    }

    // Gets the MapEntry structure associated with this script. Can return NULL.
    public final MapEntry getEntry() {
        return mapEntry;
    }
}
