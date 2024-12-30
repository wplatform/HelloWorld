package com.github.mmo.game.scripting.basescripts;

import com.github.mmo.game.map.BattlegroundMap;

public class BattlegroundMapScript extends MapScript<BattlegroundMap> {
    public BattlegroundMapScript(String name, int mapId) {
        super(name, mapId);
        if (getEntry() != null && getEntry().isBattleground()) {
            Log.outError(LogFilter.Scripts, "BattlegroundMapScript for map {0} is invalid.", mapId);
        }

        global.getScriptMgr().addScript(this);
    }
}
