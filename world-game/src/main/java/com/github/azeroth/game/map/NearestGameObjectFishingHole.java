package com.github.azeroth.game.map;


import com.github.azeroth.game.entity.gobject.GameObject;
import com.github.azeroth.game.entity.object.WorldObject;

class NearestGameObjectFishingHole implements ICheck<GameObject> {
    private final WorldObject obj;
    private float range;

    public NearestGameObjectFishingHole(WorldObject obj, float range) {
        obj = obj;
        range = range;
    }

    public final boolean invoke(GameObject go) {
        if (go.getTemplate().type == GameObjectTypes.fishingHole && go.isSpawned() && obj.isWithinDist(go, range) && obj.isWithinDist(go, go.getTemplate().fishingHole.radius)) {
            range = obj.getDistance(go);

            return true;
        }

        return false;
    }
}
