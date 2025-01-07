package com.github.azeroth.game.map;

import com.github.azeroth.game.entity.player.Player;

class AnyPlayerInPositionRangeCheck implements ICheck<Player> {
    private final Position pos;
    private final float range;
    private final boolean reqAlive;


    public AnyPlayerInPositionRangeCheck(Position pos, float range) {
        this(pos, range, true);
    }

    public AnyPlayerInPositionRangeCheck(Position pos, float range, boolean reqAlive) {
        pos = pos;
        range = range;
        reqAlive = reqAlive;
    }

    public final boolean invoke(Player u) {
        if (reqAlive && !u.isAlive()) {
            return false;
        }

        if (!u.isWithinDist3D(pos, range)) {
            return false;
        }

        return true;
    }
}
