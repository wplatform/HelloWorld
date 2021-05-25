package com.rainbowland.game.map;

public class GridDefines {
    public static boolean isValidMapCoord(float c) {
        return !Float.isInfinite(c) && (Math.abs(c) <= (MapConst.MAP_HALF_SIZE - 0.5f));
    }

    public static boolean isValidMapCoord(float x, float y) {
        return (isValidMapCoord(x) && isValidMapCoord(y));
    }

    public static boolean isValidMapCoord(float x, float y, float z) {
        return isValidMapCoord(x, y) && isValidMapCoord(z);
    }

    public static boolean isValidMapCoord(float x, float y, float z, float o) {
        return isValidMapCoord(x, y, z) && !Float.isInfinite(o);
    }
/*
    public static boolean isValidMapCoord(int mapid, float x, float y) {
        return Global.MapMgr.isValidMAP(mapid, false) && isValidMapCoord(x, y);
    }

    public static boolean isValidMapCoord(int mapid, float x, float y, float z) {
        return Global.MapMgr.isValidMAP(mapid, false) && isValidMapCoord(x, y, z);
    }

    public static boolean isValidMapCoord(uint mapid, float x, float y, float z, float o) {
        return Global.MapMgr.isValidMAP(mapid, false) && isValidMapCoord(x, y, z, o);
    }

    public static boolean isValidMapCoord(WorldLocation loc) {
        return isValidMapCoord(loc.GetMapId(), loc.GetPositionX(), loc.GetPositionY(), loc.GetPositionZ(), loc.GetOrientation());
    }

    public static float normalizeMapCoord(float c) {
        if (c > MapConst.MAP_HALF_SIZE - 0.5f)
            c = MapConst.MAP_HALF_SIZE - 0.5f;
        else if (c < -(MapConst.MAP_HALF_SIZE - 0.5f))
            c = -(MapConst.MAP_HALF_SIZE - 0.5f);
        return c;
    }

    public static GridCoord ComputeGridCoord(float x, float y) {
        double x_offset = ((double) x - MapConst.CENTER_GRID_OFFSET) / MapConst.SIZE_OF_GRIDS;
        double y_offset = ((double) y - MapConst.CENTER_GRID_OFFSET) / MapConst.SIZE_OF_GRIDS;

        uint x_val = (uint) (x_offset + MapConst.CENTER_GRID_ID + 0.5f);
        uint y_val = (uint) (y_offset + MapConst.CENTER_GRID_ID + 0.5f);
        return new GridCoord(x_val, y_val);
    }

    public static CellCoord ComputeCellCoord(float x, float y) {
        double x_offset = ((double) x - MapConst.CENTER_GRID_CELL_OFFSET) / MapConst.SIZE_OF_CELLS;
        double y_offset = ((double) y - MapConst.CENTER_GRID_CELL_OFFSET) / MapConst.SIZE_OF_CELLS;

        uint x_val = (uint) (x_offset + MapConst.CENTER_GRID_CELL_ID + 0.5f);
        uint y_val = (uint) (y_offset + MapConst.CENTER_GRID_CELL_ID + 0.5f);
        return new CellCoord(x_val, y_val);
    }
*/
}
