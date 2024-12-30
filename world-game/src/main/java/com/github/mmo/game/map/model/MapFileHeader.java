package com.github.mmo.game.map.model;

import java.nio.ByteBuffer;

public record MapFileHeader(int mapMagic,
                            int versionMagic,
                            int buildMagic,
                            int areaMapOffset,
                            int areaMapSize,
                            int heightMapOffset,
                            int heightMapSize,
                            int liquidMapOffset,
                            int liquidMapSize,
                            int holesOffset,
                            int holesSize) {

    public static final int BYTES = 44;

    public MapFileHeader(ByteBuffer buffer) {
        this(buffer.getInt(), buffer.getInt(), buffer.getInt(),
                buffer.getInt(), buffer.getInt(), buffer.getInt(), buffer.getInt(), buffer.getInt(),
                buffer.getInt(), buffer.getInt(), buffer.getInt());
    }
}
