package com.github.azeroth.game.map;

import com.github.azeroth.game.entity.object.WorldObject;

public class NoopCheckCustomizer {
    public boolean test(WorldObject o) {
        return true;
    }

    public void update(WorldObject o) {
    }
}
