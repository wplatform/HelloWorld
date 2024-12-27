package com.github.mmo.game.map;

import com.github.mmo.game.entity.gobject.GameObject;
import com.github.mmo.game.entity.object.WorldObject;

class AllGameObjectsWithEntryInRange implements ICheck<GameObject> {
    private final WorldObject pObject;

    private final int uiEntry;
    private final float fRange;


    public AllGameObjectsWithEntryInRange(WorldObject obj, int entry, float maxRange) {
        pObject = obj;
        uiEntry = entry;
        fRange = maxRange;
    }

    public final boolean invoke(GameObject go) {
        if (uiEntry == 0 || go.getEntry() == uiEntry && pObject.isWithinDist(go, fRange, false)) {
            return true;
        }

        return false;
    }
}
