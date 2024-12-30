package com.github.mmo.game.entity.areatrigger;

import com.github.mmo.dbc.defines.CurveInterpolationMode;
import com.github.mmo.dbc.model.DBCPosition2D;
import com.github.mmo.game.entity.areatrigger.model.AreaTriggerActionTypes;
import com.github.mmo.game.entity.areatrigger.model.AreaTriggerActionUserTypes;
import com.github.mmo.game.entity.areatrigger.model.AreaTriggerCreatePropertiesFlag;
import com.github.mmo.game.map.SpawnData;
import com.github.mmo.game.map.enums.SpawnObjectType;

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
        public AreaTriggerActionTypes ActionType;
        public AreaTriggerActionUserTypes TargetType;
    }

    public class AreaTriggerScaleCurvePointsTemplate {

//	AreaTriggerScaleCurvePointsTemplate();

        public CurveInterpolationMode Mode;
        public ArrayList<DBCPosition2D> Points = new ArrayList<DBCPosition2D>(2);
    }


    public class AreaTriggerTemplate {

        public AreaTriggerId Id = new AreaTriggerId();
        public AreaTriggerCreatePropertiesFlag flag;
        public ArrayList<AreaTriggerAction> Actions = new ArrayList<AreaTriggerAction>();
    }

    public class AreaTriggerSpawn extends SpawnData {
        public AreaTriggerId Id = new AreaTriggerId();
        public Integer SpellForVisuals;
        public AreaTriggerSpawn() {
            super(SpawnObjectType.AREA_TRIGGER);
        }
    }

}
