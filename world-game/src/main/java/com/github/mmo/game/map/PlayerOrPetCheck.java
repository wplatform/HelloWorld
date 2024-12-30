package com.github.mmo.game.map;


import com.github.mmo.game.entity.object.WorldObject;

public class PlayerOrPetCheck implements ICheck<WorldObject> {
    public final boolean invoke(WorldObject obj) {
        if (obj.isTypeId(TypeId.PLAYER)) {
            return false;
        }

        var creature = obj.toCreature();

        if (creature) {
            return !creature.isPet();
        }

        return true;
    }
}
