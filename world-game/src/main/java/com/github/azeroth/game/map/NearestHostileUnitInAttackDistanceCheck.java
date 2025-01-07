package com.github.azeroth.game.map;

import com.github.azeroth.game.entity.creature.Creature;
import com.github.azeroth.game.entity.unit.Unit;

class NearestHostileUnitInAttackDistanceCheck implements ICheck<unit> {
    private final Creature me;
    private final boolean force;
    private float range;


    public NearestHostileUnitInAttackDistanceCheck(Creature creature) {
        this(creature, 0);
    }

    public NearestHostileUnitInAttackDistanceCheck(Creature creature, float dist) {
        me = creature;
        range = (dist == 0 ? 9999 : dist);
        force = (dist != 0);
    }

    public final boolean invoke(Unit u) {
        if (!me.isWithinDist(u, range)) {
            return false;
        }

        if (!me.canSeeOrDetect(u)) {
            return false;
        }

        if (force) {
            if (!me.isValidAttackTarget(u)) {
                return false;
            }
        } else if (!me.canStartAttack(u, false)) {
            return false;
        }

        range = me.getDistance(u); // use found unit range as new range limit for next check

        return true;
    }
}
