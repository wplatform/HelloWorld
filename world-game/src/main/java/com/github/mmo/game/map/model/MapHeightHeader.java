package com.github.mmo.game.map.model;

import java.nio.ByteBuffer;

public record MapHeightHeader(int fourcc,
                              int flags,
                              float gridHeight,
                              float gridMaxHeight) {

    public static final int BYTES = 12;
    public static final int None = 0x0000;
    public static final int NoHeight = 0x0001;
    public static final int HeightAsInt16 = 0x0002;
    public static final int HeightAsInt8 = 0x0004;
    public static final int HasFlightBounds = 0x0008;
    public MapHeightHeader(ByteBuffer buffer) {
        this(buffer.getInt(), buffer.getInt(), buffer.getFloat(), buffer.getFloat());
    }
}
