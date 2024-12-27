package com.github.mmo.game.map.model;

import com.github.mmo.common.EnumFlag;
import com.github.mmo.game.map.enums.ZLiquidStatus;
import lombok.Data;



@Data
public class PositionFullTerrainStatus {
    private int areaId;
    private float floorZ;
    private boolean outdoors;
    private EnumFlag<ZLiquidStatus> liquidStatus;
    private WmoLocation wmoLocation;
    private LiquidData liquidInfo;
}
