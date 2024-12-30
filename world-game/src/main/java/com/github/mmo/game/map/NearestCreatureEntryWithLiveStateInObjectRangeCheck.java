package com.github.mmo.game.map;


import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.object.WorldObject;

class NearestCreatureEntryWithLiveStateInObjectRangeCheck implements ICheck<Creature> {
    private final WorldObject obj;
    private final int entry;
    private final boolean alive;
    private float range;

    public NearestCreatureEntryWithLiveStateInObjectRangeCheck(WorldObject obj, int entry, boolean alive, float range) {
        obj = obj;
        entry = entry;
        alive = alive;
        range = range;
    }

    public final boolean invoke(Creature u) {
        if (u.deathState != deathState.Dead && u.getEntry() == entry && u.isAlive() == alive && ObjectGuid.opNotEquals(u.getGUID(), obj.getGUID()) && obj.isWithinDist(u, range) && u.checkPrivateObjectOwnerVisibility(obj)) {
            range = obj.getDistance(u); // use found unit range as new range limit for next check

            return true;
        }

        return false;
    }
}
