package com.github.azeroth.game.map.grid;

import com.github.azeroth.reference.Reference;

public class GridReference<T> extends Reference<GridRefManager<T>, T, GridReference<T>> {

    @Override
    protected GridReference<T> self() {
        return this;
    }

}
