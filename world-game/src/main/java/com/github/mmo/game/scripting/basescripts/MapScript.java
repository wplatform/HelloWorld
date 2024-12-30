package com.github.mmo.game.scripting.basescripts;


import com.github.mmo.game.map.Map;
import com.github.mmo.game.scripting.ScriptObject;

public class MapScript<T extends Map> extends ScriptObject {
    private final MapRecord mapEntry;

    public MapScript(String name, int mapId) {
        super(name);
        mapEntry = CliDB.MapStorage.get(mapId);

        if (mapEntry == null) {
            Log.outError(LogFilter.Scripts, "Invalid MapScript for {0}; no such map ID.", mapId);
        }
    }

    // Gets the MapEntry structure associated with this script. Can return NULL.
    public final MapRecord getEntry() {
        return mapEntry;
    }
}
