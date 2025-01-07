package com.github.azeroth.common;


public class FlagsArray {
    protected final int[] array;

    public FlagsArray(int length) {
        array = new int[length];
    }

    public FlagsArray and(FlagsArray right) {
        for (int i = 0; i < array.length; i++) {
            array[i] &= right.array[i];
        }
        return this;
    }


    public FlagsArray or(FlagsArray right) {

        for (int i = 0; i < array.length; i++) {
            array[i] |= right.array[i];
        }
        return this;
    }


    public FlagsArray not() {
        for (int i = 0; i < array.length; i++) {
            array[i] = ~array[i];
        }
        return this;
    }

    public FlagsArray xor(FlagsArray right) {
        for (int i = 0; i < array.length; i++) {
            array[i] ^= array[i];
        }
        return this;
    }


    public boolean isEmpty() {
        for (int j : array) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }


    public int get(int i) {
        return array[i];
    }

    public void set(int i, int value) {
        array[i] = value;
    }

    public void set(int[] right) {
        System.arraycopy(right, 0, array, 0, array.length);
    }

}



