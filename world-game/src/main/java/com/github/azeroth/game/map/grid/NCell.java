package com.github.azeroth.game.map.grid;


import com.github.azeroth.game.domain.object.ObjectGuid;
import com.github.azeroth.game.entity.object.WorldObject;

import java.util.concurrent.ConcurrentHashMap;

public class NCell {

    //AllGridObjectTypes: GameObject, Creature(except pets), DynamicObject, Corpse(Bones), AreaTrigger, SceneObject, Conversation
    private final ConcurrentHashMap<ObjectGuid, WorldObject> allGridObjects = new ConcurrentHashMap<>();

    //AllWorldObjectTypes: Player, Creature(pets), Corpse(resurrectable), DynamicObject(farsight target)
    private final ConcurrentHashMap<ObjectGuid, WorldObject> allWorldObjects = new ConcurrentHashMap<>();


    public void addGridObject(WorldObject object) {
        switch (object.getTypeId()) {
            case GAME_OBJECT, CORPSE, UNIT, DYNAMIC_OBJECT, AREA_TRIGGER, SCENE_OBJECT, CONVERSATION ->
                    allGridObjects.put(object.getGUID(), object);
            default -> throw new IllegalArgumentException("Unsupported type for addGridObject: " + object.getTypeId());
        }
    }


    public void addWorldObject(WorldObject object) {
        switch (object.getTypeId()) {
            case PLAYER,CORPSE,UNIT,DYNAMIC_OBJECT -> allWorldObjects.put(object.getGUID(), object);
            default -> throw new IllegalArgumentException("Unsupported type for addWorldObject: " + object.getTypeId());
        }
    }

    public void removeWorldObject(WorldObject object) {
        allWorldObjects.remove(object.getGUID());
    }


    public void removeGridObject(WorldObject object) {
        allGridObjects.remove(object.getGUID());
    }


    public void visit(GridVisitor visitor) {
        for (var entry : allWorldObjects.entrySet()) {
            if(visitor.visit(entry.getValue()) == GridVisitorResult.TERMINATE) {
                return;
            }
        }
        for (var entry : allGridObjects.entrySet()) {
            if(visitor.visit(entry.getValue()) == GridVisitorResult.TERMINATE) {
                return;
            }
        }
    }

    public int getWorldObjectCountInCell() {
        return allGridObjects.size();
    }

}
