package com.github.mmo.game.entity.objects.update;

import java.util.Arrays;



class UpdateMaskPacketBuilder {
    public static final int CLIENT_UPDATE_MASK_BITS = Integer.SIZE;

    private int[] _mask;
    private int _lastSetBit;

    public UpdateMaskPacketBuilder(int valuesCount) {
        _lastSetBit = 0;
        int blockCount = calculateBlockCount(valuesCount);
        _mask = new int[blockCount];
        Arrays.fill(_mask, 0);
    }

    public void setBit(int bit) {
        _mask[getBlockIndex(bit)] |= getBlockFlag(bit);
        _lastSetBit = bit;
    }

    public void appendToPacket(ByteBuffer data) {
        int blockCount = calculateBlockCount(_lastSetBit + 1);
        data.put((byte) blockCount);
        if (blockCount > 0) {
            for (int i = 0; i < blockCount; i++) {
                data.putInt(_mask[i]);
            }
        }
    }

    private static int calculateBlockCount(int fieldCount) {
        return (fieldCount + CLIENT_UPDATE_MASK_BITS - 1) / CLIENT_UPDATE_MASK_BITS;
    }

    private static int getBlockIndex(int bit) {
        return bit / 32;
    }

    private static int getBlockFlag(int bit) {
        return 1 << (bit % 32);
    }
}



enum DynamicFieldChangeType {
    UNCHANGED(0),
    VALUE_CHANGED(0x7FFF),
    VALUE_AND_SIZE_CHANGED(0x8000);

    private final int value;

    DynamicFieldChangeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
