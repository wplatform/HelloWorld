package com.github.azeroth.game.map.model;

import com.github.azeroth.common.EnumFlag;
import com.github.azeroth.game.map.enums.LiquidHeaderTypeFlag;

import lombok.Data;

@Data
public class LiquidData {
    private EnumFlag<LiquidHeaderTypeFlag> typeFlags = EnumFlag.of(LiquidHeaderTypeFlag.NoWater);
    private int entry;
    private float level;
    private float depthLevel;
}
