package com.github.azeroth.game.entity.areatrigger;

import com.github.azeroth.game.entity.areatrigger.model.AreaTriggerActionType;
import com.github.azeroth.game.entity.areatrigger.model.AreaTriggerActionUserTypes;

public final class AreaTriggerAction {

    public int param;
    public AreaTriggerActionType actionType = AreaTriggerActionType.values()[0];
    public AreaTriggerActionUserTypes targetType = AreaTriggerActionUserTypes.values()[0];

    public AreaTriggerAction clone() {
        AreaTriggerAction varCopy = new AreaTriggerAction();

        varCopy.param = this.param;
        varCopy.actionType = this.actionType;
        varCopy.targetType = this.targetType;

        return varCopy;
    }
}
