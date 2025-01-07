package com.github.azeroth.game.map;


import com.github.azeroth.game.entity.object.WorldObject;
import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.spell.SpellInfo;

public class AnyAoETargetUnitInObjectRangeCheck implements ICheck<unit> {
    private final WorldObject obj;
    private final Unit funit;
    private final SpellInfo spellInfo;
    private final float range;
    private final boolean incOwnRadius;
    private final boolean incTargetRadius;


    public AnyAoETargetUnitInObjectRangeCheck(WorldObject obj, Unit funit, float range, SpellInfo spellInfo, boolean incOwnRadius) {
        this(obj, funit, range, spellInfo, incOwnRadius, true);
    }

    public AnyAoETargetUnitInObjectRangeCheck(WorldObject obj, Unit funit, float range, SpellInfo spellInfo) {
        this(obj, funit, range, spellInfo, true, true);
    }

    public AnyAoETargetUnitInObjectRangeCheck(WorldObject obj, Unit funit, float range) {
        this(obj, funit, range, null, true, true);
    }

    public AnyAoETargetUnitInObjectRangeCheck(WorldObject obj, Unit funit, float range, SpellInfo spellInfo, boolean incOwnRadius, boolean incTargetRadius) {
        obj = obj;
        funit = funit;
        spellInfo = spellInfo;
        range = range;
        incOwnRadius = incOwnRadius;
        incTargetRadius = incTargetRadius;
    }

    public final boolean invoke(Unit u) {
        // Check contains checks for: live, uninteractible, non-attackable flags, flight check and GM check, ignore totems
        if (u.isTypeId(TypeId.UNIT) && u.isTotem()) {
            return false;
        }

        if (spellInfo != null) {
            if (!u.isPlayer()) {
                if (spellInfo.hasAttribute(SpellAttr3.OnlyOnPlayer)) {
                    return false;
                }

                if (spellInfo.hasAttribute(SpellAttr5.NotOnPlayerControlledNpc) && u.isControlledByPlayer()) {
                    return false;
                }
            } else if (spellInfo.hasAttribute(SpellAttr5.NotOnPlayer)) {
                return false;
            }
        }

        if (!funit.isValidAttackTarget(u, spellInfo)) {
            return false;
        }

        var searchRadius = range;

        if (incOwnRadius) {
            searchRadius += obj.getCombatReach();
        }

        if (incTargetRadius) {
            searchRadius += u.getCombatReach();
        }

        return u.isInMap(obj) && u.inSamePhase(obj) && u.getLocation().isWithinDoubleVerticalCylinder(obj.getLocation(), searchRadius, searchRadius);
    }
}
