package com.github.azeroth.game.map.grid;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

import static com.github.azeroth.game.map.MapDefine.MAX_NUMBER_OF_CELLS;

@Getter
@Setter
public class NGrid {


    private final GridReference<NGrid> reference = new GridReference<>();

    private static final AtomicIntegerFieldUpdater<NGrid> refCntUpdater = AtomicIntegerFieldUpdater.newUpdater(NGrid.class, "refCnt");


    private final int x;
    private final int y;
    private final NCell[][] cells = new NCell[MAX_NUMBER_OF_CELLS][MAX_NUMBER_OF_CELLS];

    private final int gridId;

    private int unloadActiveLockCount;
    private boolean unloadExplicitLock;
    private volatile int refCnt = 0;


    public NGrid(int id, int x, int y) {
        gridId = id;
        this.x = x;
        this.y = y;

    }


    public NGrid(Cell cell) {
        this(cell.getId(), cell.getGridX(), cell.getGridY());
    }

    public final NCell getGrid(int x, int y) {
        return cells[x][y];
    }

    public void link(GridRefManager<NGrid> addTo) {
        reference.link(addTo, this);
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

    public void release() {
        int refCnt = refCntUpdater.decrementAndGet(this);
    }

    public int refCnt() {
        return refCntUpdater.get(this);
    }

    public void retain() {
        refCntUpdater.incrementAndGet(this);
    }
}
