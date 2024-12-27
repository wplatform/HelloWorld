package com.github.mmo.game.entity.areatrigger;

import com.github.mmo.game.entity.areatrigger.model.AreaTriggerActionTypes;
import com.github.mmo.game.entity.areatrigger.model.AreaTriggerActionUserTypes;

public final class AreaTriggerAction {
   
    public int param;
    public AreaTriggeractionTypes actionType = AreaTriggerActionTypes.values()[0];
    public AreaTriggerActionUserTypes targetType = AreaTriggerActionUserTypes.values()[0];

    public AreaTriggerAction clone() {
        AreaTriggerAction varCopy = new AreaTriggerAction();

        varCopy.param = this.param;
        varCopy.actionType = this.actionType;
        varCopy.targetType = this.targetType;

        return varCopy;
    }
}
