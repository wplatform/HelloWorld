package com.github.azeroth.game.map;

import com.github.azeroth.game.entity.unit.Unit;

public class AnyDeadUnitCheck implements ICheck<unit> {
    public final boolean invoke(Unit u) {
        return !u.isAlive();
    }
}
