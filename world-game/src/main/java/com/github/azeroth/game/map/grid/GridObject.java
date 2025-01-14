package com.github.azeroth.game.map.grid;

import com.github.azeroth.common.Assert;

public interface GridObject<T> {


    default boolean isInGrid() {
        return getGridReference().isValid();
    }

    default void addToGrid(GridRefManager<T> m) {
        Assert.state(!isInGrid());
        @SuppressWarnings("unchecked")
        T object = (T) this;
        getGridReference().link(m, object);
    }

    default void removeFromGrid() {
        Assert.state(isInGrid());
        getGridReference().unlink();
    }


    GridReference<T> getGridReference();
}
