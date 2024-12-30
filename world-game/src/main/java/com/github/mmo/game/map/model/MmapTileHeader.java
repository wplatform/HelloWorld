package com.github.mmo.game.map.model;// C# TO JAVA CONVERTER WARNING: Java does not allow user-defined value types. The behavior of this class may differ from the original:

import java.nio.ByteBuffer;

public record MmapTileHeader(int mmapMagic, int dtVersion, int mmapVersion, int size, byte usesLiquids,
                             byte[] padding) {

    public MmapTileHeader(ByteBuffer buffer) {
        this(buffer.getInt(), buffer.get(), buffer.get(), buffer.getShort(), buffer.get(), new byte[3]);
        buffer.get(this.padding);
    }
}
