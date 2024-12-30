package com.github.mmo.game.map;

import com.github.mmo.game.entity.unit.Unit;

class AllAttackableUnitsInRange implements ICheck<unit> {
    private final Unit unit;
    private final float range;

    public AllAttackableUnitsInRange(Unit obj, float range) {
        unit = obj;
        range = range;
    }

    public final boolean invoke(Unit u) {
        if (!u.isAlive()) {
            return false;
        }

        if (!u.isVisible()) {
            return false;
        }

        if (!unit.isValidAttackTarget(u)) {
            return false;
        }

        if (range != 0f) {
            if (range > 0.0f && !unit.isWithinDist(u, range, false)) {
                return false;
            }

            if (range < 0.0f && unit.isWithinDist(u, range, false)) {
                return false;
            }
        }

        return true;
    }
}
