package com.github.azeroth.game.domain.instance;

public enum EncounterFrameType {
    SET_COMBAT_RES_LIMIT    ,
    RESET_COMBAT_RES_LIMIT  ,
    ENGAGE                  ,
    DISENGAGE               ,
    UPDATE_PRIORITY         ,
    ADD_TIMER               ,
    ENABLE_OBJECTIVE        ,
    UPDATE_OBJECTIVE        ,
    DISABLE_OBJECTIVE       ,
    UNK7                    ,    // Seems to have something to do with sorting the encounter units
    ADD_COMBAT_RES_LIMIT    
}
