package com.github.azeroth.game.map;

import com.github.azeroth.game.entity.creature.Creature;
import com.github.azeroth.game.entity.unit.Unit;

class AnyAssistCreatureInRangeCheck implements ICheck<Creature> {
    private final Unit funit;
    private final Unit enemy;
    private final float range;

    public AnyAssistCreatureInRangeCheck(Unit funit, Unit enemy, float range) {
        funit = funit;
        enemy = enemy;
        range = range;
    }

    public final boolean invoke(Creature u) {
        if (u == funit) {
            return false;
        }

        if (!u.canAssistTo(funit, enemy)) {
            return false;
        }

        // too far
        // Don't use combat reach distance, range must be an absolute value, otherwise the chain aggro range will be too big
        if (!funit.isWithinDist(u, range, true, false, false)) {
            return false;
        }

        // only if see assisted creature
        if (!funit.isWithinLOSInMap(u)) {
            return false;
        }

        return true;
    }
}
