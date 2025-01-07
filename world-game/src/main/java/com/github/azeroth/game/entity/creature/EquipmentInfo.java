package com.github.azeroth.game.entity.creature;


import com.github.azeroth.game.entity.unit.UnitDefine;

public class EquipmentInfo {
    private EquipmentItem[] items = new EquipmentItem[UnitDefine.MAX_EQUIPMENT_ITEMS];

    public final EquipmentItem[] getItems() {
        return items;
    }

    public final void setItems(EquipmentItem[] value) {
        items = value;
    }
}
