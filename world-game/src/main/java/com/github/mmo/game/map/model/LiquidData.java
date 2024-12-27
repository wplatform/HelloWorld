package com.github.mmo.game.map.model;

import com.github.mmo.common.EnumFlag;
import com.github.mmo.world.map.enums.MapLiquidHeaderTypeFlags;
import lombok.Data;

@Data
public class LiquidData {
    private EnumFlag<MapLiquidHeaderTypeFlags> typeFlags = EnumFlag.of(MapLiquidHeaderTypeFlags.NoWater);
    private int entry;
    private float level;
    private float depthLevel;
}
