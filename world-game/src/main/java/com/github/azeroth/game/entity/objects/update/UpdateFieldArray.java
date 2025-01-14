package com.github.azeroth.game.entity;

import java.util.Iterator;




public class UpdateFieldArray<T> implements Iterable<T> {
    private T[] values;
    private int firstElementBit;
    private int bit;

    public UpdateFieldArray(int size, int bit, int firstElementBit) {
        setValues((T[]) new Object[size]);

        for (var i = 0; i < size; ++i) {
            getValues()[i] = new T();
        }

        setBit(bit);
        setFirstElementBit(firstElementBit);
    }

    public final T[] getValues() {
        return values;
    }

    public final void setValues(T[] value) {
        values = value;
    }

    public final int getFirstElementBit() {
        return firstElementBit;
    }

    public final void setFirstElementBit(int value) {
        firstElementBit = value;
    }

    public final int getBit() {
        return bit;
    }

    public final void setBit(int value) {
        bit = value;
    }

    public final T get(int index) {
        return getValues()[index];
    }

    public final void set(int index, T value) {
        getValues()[index] = value;
    }

    public final Iterator<T> iterator() {
        for (var obj : getValues()) {

            yield return obj;
        }
    }

    public final Iterator getEnumerator() {
        return getEnumerator();
    }

    public final int getSize() {
        return getValues().length;
    }
}
