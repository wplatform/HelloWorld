package com.github.azeroth.game.map;

import com.github.azeroth.game.entity.object.WorldObject;
import com.github.azeroth.game.entity.player.Player;

public class AnyPlayerInObjectRangeCheck implements ICheck<Player> {
    private final WorldObject obj;
    private final float range;
    private final boolean reqAlive;


    public AnyPlayerInObjectRangeCheck(WorldObject obj, float range) {
        this(obj, range, true);
    }

    public AnyPlayerInObjectRangeCheck(WorldObject obj, float range, boolean reqAlive) {
        obj = obj;
        range = range;
        reqAlive = reqAlive;
    }

    public final boolean invoke(Player pl) {
        if (reqAlive && !pl.isAlive()) {
            return false;
        }

        if (!obj.isWithinDist(pl, range)) {
            return false;
        }

        return true;
    }
}
