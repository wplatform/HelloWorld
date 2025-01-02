package com.github.mmo.game.map.grid;

import lombok.Getter;
import lombok.Setter;

import static com.github.mmo.game.map.MapDefine.MAX_NUMBER_OF_CELLS;

@Getter
@Setter
public class NGrid {


    private final GridReference<NGrid> reference = new GridReference<>();


    private final int x;
    private final int y;
    private final GridInfo gridInfo;
    private final Grid[][] cells = new Grid[MAX_NUMBER_OF_CELLS][MAX_NUMBER_OF_CELLS];

    private final int gridId;
    private GridState gridState;
    private boolean gridObjectDataLoaded;

    private int unloadActiveLockCount;
    private boolean unloadExplicitLock;


    public NGrid(int id, int x, int y, long expiry) {
        this(id, x, y, expiry, true);
    }


    public NGrid(int id, int x, int y, long expiry, boolean unload) {
        gridId = id;
        this.x = x;
        this.y = y;
        gridInfo = new GridInfo(expiry, unload);
        gridState = GridState.INVALID;
        gridObjectDataLoaded = false;

    }


    public NGrid(Cell cell, int expiry) {
        this(cell, expiry, true);
    }

    public NGrid(Cell cell, int expiry, boolean unload) {
        this(cell.getId(), cell.getGridX(), cell.getGridY(), expiry, unload);
    }

    public final Grid getGrid(int x, int y) {
        return cells[x][y];
    }

    public void link(GridRefManager<NGrid> addTo) {
        reference.link(addTo, this);
    }


    public final void update(Map map, int diff) {
        switch (getGridState()) {
            case Active:
                // Only check grid activity every (grid_expiry/10) ms, because it's really useless to do it every cycle
                getGridInfoRef().updateTimeTracker(diff);

                if (getGridInfoRef().getTimeTracker().getPassed()) {
                    if (this.<Player>getWorldObjectCountInNGrid() == 0 && !map.activeObjectsNearGrid(this)) {
                        ObjectGridStoper worker = new ObjectGridStoper(GridType.Grid);
                        visitAllGrids(worker);
                        setGridState(GridState.Idle);

                        Logs.MAPS.debug("Grid[{0}, {1}] on map {2} moved to IDLE state", getX(), getY(), map.getId());
                    } else {
                        map.resetGridExpiry(this, 0.1f);
                    }
                }

                break;
            case Idle:
                map.resetGridExpiry(this);
                setGridState(GridState.Removal);

                Logs.MAPS.debug("Grid[{0}, {1}] on map {2} moved to REMOVAL state", getX(), getY(), map.getId());

                break;
            case Removal:
                if (!getGridInfoRef().getUnloadLock()) {
                    getGridInfoRef().updateTimeTracker(diff);

                    if (getGridInfoRef().getTimeTracker().getPassed()) {
                        if (!map.unloadGrid(this, false)) {
                            Logs.MAPS.debug("Grid[{0}, {1}] for map {2} differed unloading due to players or active objects nearby", getX(), getY(), map.getId());

                            map.resetGridExpiry(this);
                        }
                    }
                }

                break;
        }
    }

    public final void visitAllGrids(GridVisitor visitor) {

        for (int x = 0; x < cells.length; ++x) {
            for (int y = 0; y < cells[x].length; ++y) {
                getGrid(x, y).visit(visitor);
            }
        }
    }


    public final void visitGrid(int x, int y, GridVisitor visitor) {
        getGrid(x, y).visit(visitor);
    }

    public final int getWorldObjectCountInNGrid() {
        int count = 0;
        for (int x = 0; x < cells.length; ++x) {
            for (int y = 0; y < cells[x].length; ++y) {
                count += getGrid(x, y).getWorldObjectCountInGrid();
            }
        }
        return count;
    }


    public final void incUnloadActiveLock() {
        ++unloadActiveLockCount;
    }

    public final void decUnloadActiveLock() {
        if (unloadActiveLockCount != 0) {
            --unloadActiveLockCount;
        }
    }
}
