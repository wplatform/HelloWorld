package com.github.mmo.game.entity.areatrigger.model;


import com.github.mmo.game.map.SpawnData;
import com.github.mmo.game.map.enums.SpawnObjectType;

public class AreaTriggerSpawn extends SpawnData {
    public AreaTriggerId triggerId = new AreaTriggerId();
    public AreaTriggerShapeInfo shape = new AreaTriggerShapeInfo();

    public AreaTriggerSpawn() {
        super(SpawnObjectType.AREA_TRIGGER);
    }
}
