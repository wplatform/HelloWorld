package com.github.azeroth.game.map.model;


import com.github.azeroth.game.map.MapDefine;

public class AreaInfo {
    public float floorZ = MapDefine.VMAP_INVALID_HEIGHT_VALUE;

    public boolean result = false;

    //Area info
    public int adtId;
    public int rootId;
    public int groupId;
    public int flags;

    //liquid data
    public int liquidType;
    public float liquidLevel;

}
