package com.github.azeroth.game.entity.object;

import com.github.azeroth.game.map.grid.Cell;


public interface MapObject {

    Cell getCurrentCell();

    void setCurrentCell(Cell currentCell);

    void setNewCellPosition(float x, float y, float z, float o);
}
