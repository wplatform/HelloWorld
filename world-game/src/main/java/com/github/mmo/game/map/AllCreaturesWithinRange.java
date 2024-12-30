package com.github.mmo.game.map;

import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.object.WorldObject;

public class AllCreaturesWithinRange implements ICheck<Creature> {
    private final WorldObject pObject;
    private final float fRange;


    public AllCreaturesWithinRange(WorldObject obj) {
        this(obj, 0f);
    }

    public AllCreaturesWithinRange(WorldObject obj, float maxRange) {
        pObject = obj;
        fRange = maxRange;
    }

    public final boolean invoke(Creature creature) {
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
