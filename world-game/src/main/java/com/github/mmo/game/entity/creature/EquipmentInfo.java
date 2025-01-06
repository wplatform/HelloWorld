package com.github.mmo.game.entity.creature;


public class EquipmentInfo {
    private EquipmentItem[] items = new EquipmentItem[SharedConst.MaxEquipmentItems];

    public final EquipmentItem[] getItems() {
        return items;
    }

    public final void setItems(EquipmentItem[] value) {
        items = value;
    }
}
