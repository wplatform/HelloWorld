package com.github.azeroth.game.map;


import com.github.azeroth.game.entity.creature.Creature;
import com.github.azeroth.game.entity.object.WorldObject;
import com.github.azeroth.game.map.interfaces.*;

import java.util.ArrayList;
import java.util.Objects;


public class CreatureListSearcher implements IGridNotifierCreature {
    private final ArrayList<Creature> objects;
    private final ICheck<Creature> check;
    public PhaseShift phaseShift;

    public CreatureListSearcher(WorldObject searcher, ArrayList<Creature> objects, ICheck<Creature> check, GridType gridType) {
        phaseShift = searcher.getPhaseShift();
        objects = objects;
        check = check;
        setGridType(gridType);
    }    private gridType gridType = getGridType().values()[0];

    public final GridType getGridType() {
        return gridType;
    }

    public final void setGridType(GridType value) {
        gridType = value;
    }

    public final void visit(list<Creature> objs) {
        for (var i = 0; i < objs.size(); ++i) {
            var creature = objs.get(i);

            if (creature.inSamePhase(phaseShift)) {
                if (check.invoke(creature)) {
                    Objects.add(creature);
                }
            }
        }
    }


}
