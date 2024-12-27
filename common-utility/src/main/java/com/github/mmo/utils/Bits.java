package com.github.mmo.utils;

public class Bits {


    private int value;
    private int limit;
    private int bitPos;

    public Bits(int value, int limit) {
        this.value = value;
        this.limit = limit;
        this.bitPos = limit;
    }


    public static Bits of(int value) {
        return new Bits(value, 32);
    }

    public static Bits of(short value) {
        return new Bits(value, 16);
    }

    public static Bits of(byte value) {
        return new Bits(value, 8);
    }

    public static Bits empty() {
        return of(0);
    }

    // High byte order writing
    public Bits addBit(boolean bitValue) {
        if (bitPos < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.value |= (bitValue ? 1 : 0) << --bitPos;
        return this;
    }


    public Bits addBits(int bitValue, int bits) {
        for (int i = bits - 1; i >= 0; --i) {
            addBit(((bitValue >> i) & 1) == 1);
        }
        return this;
    }


    public byte[] values() {
        /*
        b[3] = (byte) (value & 0xff);
        b[2] = (byte) (value >> 8 & 0xff);
        b[1] = (byte) (value >> 16 & 0xff);
        b[0] = (byte) (value >> 24 & 0xff);
         */

        int length = (limit / 8) - (bitPos / 8);
        byte[] b = new byte[length];
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (value >> limit - 8 - i * 8 & 0xff);
        }
        return b;
    }



    public boolean getBit() {
        return ((value >> (limit - --bitPos)) & 1) != 0;
    }
}
