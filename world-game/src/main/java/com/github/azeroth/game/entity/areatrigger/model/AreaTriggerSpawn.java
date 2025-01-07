package com.github.azeroth.game.entity.areatrigger.model;


import com.github.azeroth.game.domain.spawn.SpawnData;
import com.github.azeroth.game.domain.spawn.SpawnObjectType;

public class AreaTriggerSpawn extends SpawnData {
    public AreaTriggerId triggerId = new AreaTriggerId();
    public AreaTriggerShapeInfo shape = new AreaTriggerShapeInfo();

    public AreaTriggerSpawn() {
        super(SpawnObjectType.AREA_TRIGGER);
    }
}
