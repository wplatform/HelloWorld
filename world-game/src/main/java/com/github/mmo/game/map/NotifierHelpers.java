package com.github.mmo.game.map;


import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.unit.Unit;

public final class NotifierHelpers {
    public static void creatureUnitRelocationWorker(Creature c, Unit u) {
        if (!u.isAlive() || !c.isAlive() || c == u || u.isInFlight()) {
            return;
        }

        if (!c.hasUnitState(UnitState.Sightless)) {
            if (c.isAIEnabled() && c.canSeeOrDetect(u, false, true)) {
                c.getAI().moveInLineOfSight_Safe(u);
            } else {
                if (u.isTypeId(TypeId.PLAYER) && u.getHasStealthAura() && c.isAIEnabled() && c.canSeeOrDetect(u, false, true, true)) {
                    c.getAI().triggerAlert(u);
                }
            }
        }
    }
}
