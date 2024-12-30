package com.github.mmo.game.map;


import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.map.interfaces.*;


public class CreatureWorker implements IGridNotifierCreature {
    private final PhaseShift phaseShift;
    private final IDoWork<Creature> doWork;

    public CreatureWorker(WorldObject searcher, IDoWork<Creature> work, GridType gridType) {
        phaseShift = searcher.getPhaseShift();
        doWork = work;
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
                doWork.invoke(creature);
            }
        }
    }


}
