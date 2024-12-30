package com.github.mmo.game.map;


import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.gobject.GameObject;
import com.github.mmo.game.map.grid.Cell;
import com.github.mmo.game.map.grid.NGrid;
import com.github.mmo.game.map.interfaces.*;


class ObjectGridLoader extends ObjectGridLoaderBase implements IGridNotifierGameObject, IGridNotifierCreature, IGridNotifierAreaTrigger {
    public ObjectGridLoader(NGrid grid, Map map, Cell cell, GridType gridType) {
        super(grid, map, cell);
        setGridType(gridType);
    }    private gridType gridType = getGridType().values()[0];

    public final GridType getGridType() {
        return gridType;
    }

    public final void setGridType(GridType value) {
        gridType = value;
    }

    public final void visit(list<areaTrigger> objs) {
        var cellCoord = i_cell.getCellCoord();
        var areaTriggers = global.getAreaTriggerDataStorage().GetAreaTriggersForMapAndCell(i_map.getId(), cellCoord.getId());

        if (areaTriggers == null || areaTriggers.isEmpty()) {
            return;
        }

        tangible.RefObject<Integer> tempRef_i_areaTriggers = new tangible.RefObject<Integer>(i_areaTriggers);
        this.<areaTrigger>LoadHelper(areaTriggers, cellCoord, tempRef_i_areaTriggers, i_map);
        i_areaTriggers = tempRef_i_areaTriggers.refArgValue;
    }

    public final void visit(list<Creature> objs) {
        var cellCoord = i_cell.getCellCoord();
        var cellguids = global.getObjectMgr().getCellObjectGuids(i_map.getId(), i_map.getDifficultyID(), cellCoord.getId());

        if (cellguids == null || cellguids.creatures.isEmpty()) {
            return;
        }

        tangible.RefObject<Integer> tempRef_i_creatures = new tangible.RefObject<Integer>(i_creatures);
        this.<Creature>LoadHelper(cellguids.creatures, cellCoord, tempRef_i_creatures, i_map);
        i_creatures = tempRef_i_creatures.refArgValue;
    }

    public final void visit(list<GameObject> objs) {
        var cellCoord = i_cell.getCellCoord();
        var cellguids = global.getObjectMgr().getCellObjectGuids(i_map.getId(), i_map.getDifficultyID(), cellCoord.getId());

        if (cellguids == null || cellguids.gameObjects.isEmpty()) {
            return;
        }

        tangible.RefObject<Integer> tempRef_i_gameObjects = new tangible.RefObject<Integer>(i_gameObjects);
        this.<GameObject>LoadHelper(cellguids.gameobjects, cellCoord, tempRef_i_gameObjects, i_map);
        i_gameObjects = tempRef_i_gameObjects.refArgValue;
    }

    public final void loadN() {
        i_creatures = 0;
        i_gameObjects = 0;
        i_corpses = 0;
        i_cell.data.celly = 0;

        for (int x = 0; x < MapDefine.MaxCells; ++x) {
            i_cell.data.cellx = x;

            for (int y = 0; y < MapDefine.MaxCells; ++y) {
                i_cell.data.celly = y;

                i_grid.visitGrid(x, y, this);

                ObjectWorldLoader worker = new ObjectWorldLoader(this, gridType.World);
                i_grid.visitGrid(x, y, worker);
            }
        }

        Log.outDebug(LogFilter.Maps, String.format("%1$s gameObjects, %2$s Creatures, %3$s AreaTrriggers and %4$s Corpses/Bones loaded for grid %5$s on map %6$s", i_gameObjects, i_creatures, i_areaTriggers, i_corpses, i_grid.getGridId(), i_map.getId()));
    }


}

//Stop the creatures before unloading the NGrid

//Move the foreign creatures back to respawn positions before unloading the NGrid

//Clean up and remove from world

//Delete objects before deleting NGrid

