package com.github.azeroth.game.domain.map;


import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Coordinate {

    private final int limit;
    private int axisX;
    private int axisY;

    private Coordinate(int limit, int axisX, int axisY) {
        this.limit = limit;
        this.axisX = axisX;
        this.axisY = axisY;
    }

    public static Coordinate createGridCoordinate(int x, int y) {
        return new Coordinate(MapDefine.MAX_NUMBER_OF_GRIDS, x, y);
    }

    public static Coordinate createCellCoordinate(int x, int y) {
        return new Coordinate(MapDefine.TOTAL_NUMBER_OF_CELLS_PER_MAP, x, y);
    }

    public void decX(int val) {
        if (axisX > val)
            axisX -= val;
        else
            axisX = 0;
    }

    public void incX(int val) {
        if (axisX + val < limit)
            axisX += val;
        else
            axisX = limit - 1;
    }

    public void decY(int val) {
        if (axisY > val)
            axisY -= val;
        else
            axisY = 0;
    }

    public void incY(int val) {
        if (axisY + val < limit)
            axisY += val;
        else
            axisY = limit - 1;
    }

    public boolean isCoordinateValid() {
        return axisX < limit && axisY < limit;
    }

    public Coordinate normalize() {
        axisX = Math.min(axisX, limit - 1);
        axisY = Math.min(axisY, limit - 1);
        return this;
    }

    public int getId() {
        return axisY * limit + axisX;
    }

    public int axisX() {
        return axisX;
    }

    public int axisY() {
        return axisY;
    }

    public boolean isGridCoordinate() {
        return limit == MapDefine.MAX_NUMBER_OF_GRIDS;
    }

}
