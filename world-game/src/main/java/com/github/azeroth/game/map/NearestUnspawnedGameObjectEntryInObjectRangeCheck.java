package com.github.azeroth.game.map;

import com.github.azeroth.game.entity.gobject.GameObject;
import com.github.azeroth.game.entity.object.WorldObject;

class NearestUnspawnedGameObjectEntryInObjectRangeCheck implements ICheck<GameObject> {
    private final WorldObject obj;
    private final int entry;
    private float range;

    public NearestUnspawnedGameObjectEntryInObjectRangeCheck(WorldObject obj, int entry, float range) {
        obj = obj;
        entry = entry;
        range = range;
    }

    public final boolean invoke(GameObject go) {
        if (!go.isSpawned() && go.getEntry() == entry && ObjectGuid.opNotEquals(go.getGUID(), obj.getGUID()) && obj.isWithinDist(go, range)) {
            range = obj.getDistance(go); // use found GO range as new range limit for next check

            return true;
        }

        return false;
    }
}
