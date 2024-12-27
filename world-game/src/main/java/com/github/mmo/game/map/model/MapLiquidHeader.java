package com.github.mmo.game.map.model;

import java.nio.ByteBuffer;

public record MapLiquidHeader(int fourcc,
                       byte flags,
                       byte liquidFlags,
                       short liquidType,
                       byte offsetX,
                       byte offsetY,
                       byte width,
                       byte height,
                       float liquidLevel) {

    public static final byte FLAG_NONE = 0x0000;
    public static final byte FLAG_NO_TYPE = 0x0001;
    public static final byte FLAG_NO_HEIGHT = 0x0002;
    public static final int BYTES = 14;

    public MapLiquidHeader(ByteBuffer buffer) {
        this(buffer.getInt(), buffer.get(), buffer.get(), buffer.getShort(),
                buffer.get(), buffer.get(), buffer.get(), buffer.get(), buffer.getFloat());
    }


}
