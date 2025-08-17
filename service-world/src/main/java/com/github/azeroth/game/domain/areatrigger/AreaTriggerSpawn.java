package com.github.azeroth.game.domain.areatrigger;


import com.github.azeroth.game.domain.spawn.SpawnData;
import com.github.azeroth.game.domain.spawn.SpawnObjectType;

public class AreaTriggerSpawn extends SpawnData {
    public AreaTriggerId triggerId;
    public AreaTriggerShapeInfo shape = new AreaTriggerShapeInfo();

    public AreaTriggerSpawn() {
        type = SpawnObjectType.AREA_TRIGGER;
    }
}
