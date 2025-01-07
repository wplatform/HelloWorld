package com.github.azeroth.game.map.grid;


import com.github.azeroth.game.entity.object.WorldObject;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class GridVisitor implements Predicate<GridVisitOption> {

    private final Set<GridVisitOption> visitOptions;
    private final Consumer<GridRefManager<? extends WorldObject>> consumer;


    public GridVisitor(Set<GridVisitOption> visitOptions, Consumer<GridRefManager<? extends WorldObject>> consumer) {
        this.visitOptions = visitOptions;
        this.consumer = consumer;
    }


    public void visit(GridRefManager<? extends WorldObject> source) {
        consumer.accept(source);
    }

    @Override
    public boolean test(GridVisitOption visitOption) {
        return visitOptions.contains(visitOption);
    }

}
