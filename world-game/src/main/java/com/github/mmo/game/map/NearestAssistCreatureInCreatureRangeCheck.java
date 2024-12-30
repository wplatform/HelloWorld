package com.github.mmo.game.map;

import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.unit.Unit;

class NearestAssistCreatureInCreatureRangeCheck implements ICheck<Creature> {
    private final Creature obj;
    private final Unit enemy;
    private float range;

    public NearestAssistCreatureInCreatureRangeCheck(Creature obj, Unit enemy, float range) {
        obj = obj;
        enemy = enemy;
        range = range;
    }

    public final boolean invoke(Creature u) {
        if (u == obj) {
            return false;
        }

        if (!u.canAssistTo(obj, enemy)) {
            return false;
        }

        // Don't use combat reach distance, range must be an absolute value, otherwise the chain aggro range will be too big
        if (!obj.isWithinDist(u, range, true, false, false)) {
            return false;
        }

        if (!obj.isWithinLOSInMap(u)) {
            return false;
        }

        range = obj.getDistance(u); // use found unit range as new range limit for next check

        return true;
    }
}
