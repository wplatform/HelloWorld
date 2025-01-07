package com.github.azeroth.game.map;

import com.github.azeroth.game.entity.creature.Creature;
import com.github.azeroth.game.entity.object.WorldObject;

public class AllCreaturesOfEntryInRange implements ICheck<Creature> {
    private final WorldObject pObject;
    private final int uiEntry;
    private final float fRange;


    public AllCreaturesOfEntryInRange(WorldObject obj, int entry) {
        this(obj, entry, 0f);
    }

    public AllCreaturesOfEntryInRange(WorldObject obj, int entry, float maxRange) {
        pObject = obj;
        uiEntry = entry;
        fRange = maxRange;
    }

    public final boolean invoke(Creature creature) {
        if (uiEntry != 0) {
            if (creature.getEntry() != uiEntry) {
                return false;
            }
        }

        if (fRange != 0f) {
            if (fRange > 0.0f && !pObject.isWithinDist(creature, fRange, false)) {
                return false;
            }

            if (fRange < 0.0f && pObject.isWithinDist(creature, fRange, false)) {
                return false;
            }
        }

        return true;
    }
}
