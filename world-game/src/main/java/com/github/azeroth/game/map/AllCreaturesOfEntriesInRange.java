package com.github.azeroth.game.map;

import com.github.azeroth.game.entity.creature.Creature;
import com.github.azeroth.game.entity.object.WorldObject;

public class AllCreaturesOfEntriesInRange implements ICheck<Creature> {
    private final WorldObject pObject;
    private final int[] uiEntry;
    private final float fRange;


    public AllCreaturesOfEntriesInRange(WorldObject obj, int[] entry) {
        this(obj, entry, 0f);
    }

    public AllCreaturesOfEntriesInRange(WorldObject obj, int[] entry, float maxRange) {
        pObject = obj;
        uiEntry = entry;
        fRange = maxRange;
    }

    public final boolean invoke(Creature creature) {
        if (uiEntry != null) {
            var match = false;

            for (var entry : uiEntry) {
                if (entry != 0 && creature.getEntry() == entry) {
                    match = true;
                }
            }

            if (!match) {
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
