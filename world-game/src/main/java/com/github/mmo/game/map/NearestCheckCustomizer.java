package com.github.mmo.game.map;

import com.github.mmo.game.entity.object.WorldObject;

class NearestCheckCustomizer extends NoopCheckCustomizer {
    private final WorldObject obj;
    private float range;

    public NearestCheckCustomizer(WorldObject obj, float range) {
        obj = obj;
        range = range;
    }

    @Override
    public boolean test(WorldObject o) {
        return obj.isWithinDist(o, range);
    }

    @Override
    public void update(WorldObject o) {
        range = obj.getDistance(o);
    }
}
