package com.github.mmo.game.entity.creature;

public final class EquipmentItem {
    public int itemId;
    public short appearanceModId;
    public short itemVisual;

    public EquipmentItem clone() {
        EquipmentItem varCopy = new EquipmentItem();

        varCopy.itemId = this.itemId;
        varCopy.appearanceModId = this.appearanceModId;
        varCopy.itemVisual = this.itemVisual;

        return varCopy;
    }
}
