package com.github.azeroth.game.scripting.basescripts;

import com.github.azeroth.game.map.BattlegroundMap;

public class BattlegroundMapScript extends MapScript<BattlegroundMap> {
    public BattlegroundMapScript(String name, int mapId) {
        super(name, mapId);
        if (getEntry() != null && getEntry().isBattleground()) {
            Log.outError(LogFilter.Scripts, "BattlegroundMapScript for map {0} is invalid.", mapId);
        }

        global.getScriptMgr().addScript(this);
    }
}
