package com.github.azeroth.game.domain.areatrigger;

import com.github.azeroth.dbc.defines.CurveInterpolationMode;
import com.github.azeroth.dbc.model.DBCPosition2D;
import com.github.azeroth.game.domain.areatrigger.AreaTriggerActionType;
import com.github.azeroth.game.domain.areatrigger.AreaTriggerActionUserTypes;
import com.github.azeroth.game.domain.areatrigger.AreaTriggerCreatePropertiesFlag;
import com.github.azeroth.game.domain.spawn.SpawnData;
import com.github.azeroth.game.domain.spawn.SpawnObjectType;

import java.util.ArrayList;

public interface AreaTriggerDefine {

    int MAX_AREA_TRIGGER_ENTITY_DATA = 8;
    int MAX_AREA_TRIGGER_SCALE = 7;
}
