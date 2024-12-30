package com.github.mmo.game.entity.unit;

import com.github.mmo.game.spell.AuraApplication;

import java.util.Comparator;


class VisibleAuraSlotCompare implements Comparator<AuraApplication> {
    public final int compare(AuraApplication x, AuraApplication y) {
        return (new Byte(x.getSlot())).compareTo(y.getSlot());
    }
}
