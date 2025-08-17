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

    int MAX_AREATRIGGER_ENTITY_DATA = 8;
    int MAX_AREATRIGGER_SCALE = 7;

    public class AreaTriggerId {

        public int Id = 0;
        public boolean IsCustom = false;


//	friend boolean operator ==(AreaTriggerId const& left, AreaTriggerId const& right) = default;
    }


    public class AreaTriggerAction {

        public int Param;
        public AreaTriggerActionType ActionType;
        public AreaTriggerActionUserTypes TargetType;
    }

    public class AreaTriggerScaleCurvePointsTemplate {


        public CurveInterpolationMode Mode;
        public ArrayList<DBCPosition2D> Points = new ArrayList<DBCPosition2D>(2);
    }



}
