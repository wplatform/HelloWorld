package com.github.azeroth.game.map;

import com.github.azeroth.game.entity.object.WorldObject;
import com.github.azeroth.game.entity.unit.Unit;

public class AnyGroupedUnitInObjectRangeCheck implements ICheck<unit> {
    private final WorldObject source;
    private final Unit refUnit;
    private final float range;
    private final boolean raid;
    private final boolean playerOnly;
    private final boolean incOwnRadius;
    private final boolean incTargetRadius;


    public AnyGroupedUnitInObjectRangeCheck(WorldObject obj, Unit funit, float range, boolean raid, boolean playerOnly, boolean incOwnRadius) {
        this(obj, funit, range, raid, playerOnly, incOwnRadius, true);
    }

    public AnyGroupedUnitInObjectRangeCheck(WorldObject obj, Unit funit, float range, boolean raid, boolean playerOnly) {
        this(obj, funit, range, raid, playerOnly, true, true);
    }

    public AnyGroupedUnitInObjectRangeCheck(WorldObject obj, Unit funit, float range, boolean raid) {
        this(obj, funit, range, raid, false, true, true);
    }

    public AnyGroupedUnitInObjectRangeCheck(WorldObject obj, Unit funit, float range, boolean raid, boolean playerOnly, boolean incOwnRadius, boolean incTargetRadius) {
        this.source = obj;
        this.refUnit = funit;
        this.range = range;
        this.raid = raid;
        this.playerOnly = playerOnly;
        this.incOwnRadius = incOwnRadius;
        this.incTargetRadius = incTargetRadius;
    }

    public final boolean invoke(Unit u) {
        if (playerOnly && !u.isPlayer()) {
            return false;
        }

        if (raid) {
            if (!refUnit.isInRaidWith(u)) {
                return false;
            }
        } else if (!refUnit.isInPartyWith(u)) {
            return false;
        }

        if (refUnit.isHostileTo(u)) {
            return false;
        }

        if (!u.isAlive()) {
            return false;
        }

        var searchRadius = range;

        if (incOwnRadius) {
            searchRadius += source.getCombatReach();
        }

        if (incTargetRadius) {
            searchRadius += u.getCombatReach();
        }

        return u.isInMap(source) && u.inSamePhase(source) && u.getLocation().isWithinDoubleVerticalCylinder(source.getLocation(), searchRadius, searchRadius);
    }
}
