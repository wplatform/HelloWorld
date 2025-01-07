package com.github.azeroth.game.garrison;


import com.github.azeroth.game.entity.gobject.GameObject;
import com.github.azeroth.game.map.MapDefine;
import com.github.azeroth.game.map.grid.Cell;
import com.github.azeroth.game.map.grid.Grid;
import com.github.azeroth.game.map.interfaces.*;

class GarrisonGridLoader implements IGridNotifierGameObject {
    private final Cell i_cell;
    private final Grid i_grid;
    private final GarrisonMap i_map;
    private final Garrison i_garrison;
    private final int i_creatures;
    private int i_gameObjects;
    public GarrisonGridLoader(Grid grid, GarrisonMap map, Cell cell) {
        this(grid, map, cell, gridType.Grid);
    }    private gridType gridType = getGridType().values()[0];

    public GarrisonGridLoader(Grid grid, GarrisonMap map, Cell cell, GridType gridType) {
        i_cell = cell;
        i_grid = grid;
        i_map = map;
        i_garrison = map.getGarrison();
        setGridType(gridType);
    }

    public final GridType getGridType() {
        return gridType;
    }

    public final void setGridType(GridType value) {
        gridType = value;
    }

    public final void visit(list<GameObject> objs) {
        var plots = i_garrison.getPlots();

        if (!plots.isEmpty()) {
            var cellCoord = i_cell.getCellCoord();

            for (var plot : plots) {
                var spawn = plot.packetInfo.plotPos;

                if (CellCoord.opNotEquals(cellCoord, MapDefine.computeCellCoord(spawn.X, spawn.Y))) {
                    continue;
                }

                var go = plot.createGameObject(i_map, i_garrison.getFaction());

                if (!go) {
                    continue;
                }

                var cell = new Cell(cellCoord);
                i_map.addToGrid(go, cell);
                go.addToWorld();
                ++i_gameObjects;
            }
        }
    }

    public final void loadN() {
        if (i_garrison != null) {
            i_cell.data.celly = 0;

            for (int x = 0; x < MapDefine.MaxCells; ++x) {
                i_cell.data.cellx = x;

                for (int y = 0; y < MapDefine.MaxCells; ++y) {
                    i_cell.data.celly = y;

                    //Load creatures and game objects
                    i_grid.visitGrid(x, y, this);
                }
            }
        }

        Logs.MAPS.debug("{0} GameObjects and {1} Creatures loaded for grid {2} on map {3}", i_gameObjects, i_creatures, i_grid.getGridId(), i_map.getId());
    }


}
