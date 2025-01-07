package com.github.azeroth.game.map;

import com.github.azeroth.game.entity.unit.Unit;

class AllFriendlyUnitsInRange implements ICheck<unit> {
    private final Unit unit;
    private final float range;

    public AllFriendlyUnitsInRange(Unit obj, float range) {
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

        if (!u.isFriendlyTo(unit)) {
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
