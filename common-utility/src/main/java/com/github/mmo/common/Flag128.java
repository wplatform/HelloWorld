package com.github.mmo.common;

public class Flag128 extends FlagsArray {

    public Flag128() {
        this(0, 0, 0, 0);
    }

    public Flag128(int p1, int p2, int p3, int p4) {
        super(4);
        array[0] = p1;
        array[1] = p2;
        array[2] = p3;
        array[3] = p4;
    }

    public boolean isEqual(int p1, int p2, int p3, int p4) {
        return (array[0] ==p1 && array[1] == p2 && array[2] == p3 && array[3] == p4);
    }

    public boolean hasFlag(int p1, int p2, int p3, int p4) {
        return ((array[0] & p1) != 0 || (array[1] & p2) != 0 || (array[2] & p3) != 0 || (array[3] & p4) != 0);
    }

    public void set(int p1, int p2, int p3, int p4) {
        array[0] = p1;
        array[1] = p2;
        array[2] = p3;
        array[3] = p4;
    }
}