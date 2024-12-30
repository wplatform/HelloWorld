package com.github.mmo.game.map;


import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.map.interfaces.*;


public class AIRelocationNotifier implements IGridNotifierCreature {
    private final Unit unit;
    private final boolean isCreature;

    public AIRelocationNotifier(Unit unit, GridType gridType) {
        unit = unit;
        isCreature = unit.isTypeId(TypeId.UNIT);
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
            NotifierHelpers.creatureUnitRelocationWorker(creature, unit);

            if (isCreature) {
                NotifierHelpers.creatureUnitRelocationWorker(unit.toCreature(), creature);
            }
        }
    }


}
