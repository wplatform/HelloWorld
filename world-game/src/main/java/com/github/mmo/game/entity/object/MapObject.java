package com.github.mmo.game.entity.object;

import com.github.mmo.game.map.grid.Cell;


public interface MapObject {

    Cell getCurrentCell();
    void setCurrentCell(Cell currentCell);

    void setNewCellPosition(float x, float y, float z, float o);


    enum CellMoveState {
        NONE, //not in move list
        ACTIVE, //in move list
        INACTIVE, //in move list but should not move
    }
}