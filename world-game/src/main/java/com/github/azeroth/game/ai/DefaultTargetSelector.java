package com.github.azeroth.game.ai;


import com.github.azeroth.game.entity.unit.Unit;

// default predicate function to select target based on distance, player and/or aura criteria
public class DefaultTargetSelector implements ICheck<unit> {
    private final Unit me;
    private final float dist;
    private final boolean playerOnly;
    private final Unit exception;
    private final int aura;

    /**
     * @param unit       the reference unit
     * @param dist       if 0: ignored, if > 0: maximum distance to the reference unit, if < 0: minimum distance to the reference unit
     * @param playerOnly self explaining
     * @param withTank   allow current tank to be selected
     * @param aura       if 0: ignored, if > 0: the target shall have the aura, if < 0, the target shall NOT have the aura
     */
    public DefaultTargetSelector(Unit unit, float dist, boolean playerOnly, boolean withTank, int aura) {
        me = unit;
        dist = dist;
        playerOnly = playerOnly;
        exception = !withTank ? unit.getThreatManager().getLastVictim() : null;
        aura = aura;
    }

    public final boolean invoke(Unit target) {
        if (me == null) {
            return false;
        }

        if (target == null) {
            return false;
        }

        if (exception != null && target == exception) {
            return false;
        }

        if (playerOnly && !target.isTypeId(TypeId.PLAYER)) {
            return false;
        }

        if (dist > 0.0f && !me.isWithinCombatRange(target, dist)) {
            return false;
        }

        if (dist < 0.0f && me.isWithinCombatRange(target, -_dist)) {
            return false;
        }

        if (aura != 0) {
            if (aura > 0) {
                if (!target.hasAura((int) aura)) {
                    return false;
                }
            } else {
                if (target.hasAura((int) -_aura)) {
                    return false;
                }
            }
        }

        return false;
    }
}

// Target selector for spell casts checking range, auras and attributes
// todo Add more checks from spell.CheckCast

// Very simple target selector, will just skip main target
// NOTE: When passing to UnitAI.SelectTarget remember to use 0 as position for random selection
//       because tank will not be in the temporary list

// Simple selector for units using mana

