package com.github.mmo.game.map.grid;

import com.github.mmo.reference.Reference;

public class GridReference<T> extends Reference<GridRefManager<T>, T, GridReference<T>> {

    @Override
    protected GridReference<T> self() {
        return this;
    }

}
