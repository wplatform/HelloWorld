package com.github.azeroth.game.map.model;

import com.github.azeroth.common.EnumFlag;
import com.github.azeroth.world.map.enums.MapLiquidHeaderTypeFlags;
import lombok.Data;

@Data
public class LiquidData {
    private EnumFlag<MapLiquidHeaderTypeFlags> typeFlags = EnumFlag.of(MapLiquidHeaderTypeFlags.NoWater);
    private int entry;
    private float level;
    private float depthLevel;
}
