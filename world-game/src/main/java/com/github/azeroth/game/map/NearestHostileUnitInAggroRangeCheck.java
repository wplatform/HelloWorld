package com.github.azeroth.game.map;

import com.github.azeroth.game.entity.creature.Creature;
import com.github.azeroth.game.entity.unit.Unit;

class NearestHostileUnitInAggroRangeCheck implements ICheck<unit> {
    private final Creature me;
    private final boolean useLOS;
    private final boolean ignoreCivilians;


    public NearestHostileUnitInAggroRangeCheck(Creature creature, boolean useLOS) {
        this(creature, useLOS, false);
    }

    public NearestHostileUnitInAggroRangeCheck(Creature creature) {
        this(creature, false, false);
    }

    public NearestHostileUnitInAggroRangeCheck(Creature creature, boolean useLOS, boolean ignoreCivilians) {
        me = creature;
        useLOS = useLOS;
        ignoreCivilians = ignoreCivilians;
    }

    public final boolean invoke(Unit u) {
        if (!u.isHostileTo(me)) {
            return false;
        }

        if (!u.isWithinDist(me, me.getAggroRange(u))) {
            return false;
        }

        if (!me.isValidAttackTarget(u)) {
            return false;
        }

        if (useLOS && !u.isWithinLOSInMap(me)) {
            return false;
        }

        // pets in aggressive do not attack civilians
        if (ignoreCivilians) {
            var c = u.toCreature();

            if (c != null) {
                if (c.isCivilian()) {
                    return false;
                }
            }
        }

        return true;
    }
}
