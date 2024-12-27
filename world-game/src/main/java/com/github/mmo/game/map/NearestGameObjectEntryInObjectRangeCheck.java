package com.github.mmo.game.map;

import com.github.mmo.game.entity.gobject.GameObject;
import com.github.mmo.game.entity.object.WorldObject;

class NearestGameObjectEntryInObjectRangeCheck implements ICheck<GameObject> {
    private final WorldObject obj;

    private final int entry;
    private final boolean spawnedOnly;
    private float range;


    public NearestGameObjectEntryInObjectRangeCheck(WorldObject obj, int entry, float range) {
        this(obj, entry, range, true);
    }

        public NearestGameObjectEntryInObjectRangeCheck(WorldObject obj, int entry, float range, boolean spawnedOnly) {
        obj = obj;
        entry = entry;
        range = range;
        spawnedOnly = spawnedOnly;
    }

    public final boolean invoke(GameObject go) {
        if ((!spawnedOnly || go.isSpawned()) && go.getEntry() == entry && ObjectGuid.opNotEquals(go.getGUID(), obj.getGUID()) && obj.isWithinDist(go, range)) {
            range = obj.getDistance(go); // use found GO range as new range limit for next check

            return true;
        }

        return false;
    }
}
