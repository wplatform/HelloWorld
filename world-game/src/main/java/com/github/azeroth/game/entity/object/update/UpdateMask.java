package com.github.azeroth.game.entity.object.update;

import java.util.Arrays;

public class UpdateMask {
    private byte[] _bits;
    private int _fieldCount;

    public UpdateMask() {
        _bits = null;
        _fieldCount = 0;
    }

    public void setBit(int index) {
        _bits[index] = 1;
    }

    public void unsetBit(int index) {
        _bits[index] = 0;
    }

    public boolean getBit(int index) {
        return _bits[index] != 0;
    }

    public void setCount(int valuesCount) {
        _bits = new byte[valuesCount];
        Arrays.fill(_bits, (byte) 0);
        _fieldCount = valuesCount;
    }

    public void clear() {
        if (_bits != null) {
            Arrays.fill(_bits, (byte) 0);
        }
    }
}
