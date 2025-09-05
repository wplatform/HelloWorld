package com.github.azeroth.game.entity.object.update;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;


public final class Array<T> implements Iterable<T> {
    private final T[] values;
    private final int bit;
    private final int firstElementBit;
    private final UpdateMaskObject owner;
    private final Class<T> elementType;

    public final int length;

    public Array(int length, int bit, int firstElementBit, UpdateMaskObject owner) {
        this.owner = owner;
        this.values = (T[]) new Object[length];
        this.bit = bit;
        this.firstElementBit = firstElementBit;
        this.length = length;
        this.elementType = (Class<T>) values.getClass().getComponentType();
    }


    public T get(int index) {
        return values[index];
    }

    public void set(int index, T value) {
        if (!Objects.equals(values[index], value)) {
            values[index] = value;
            owner.fireArrayMarkChanged(elementType, bit, firstElementBit, index);
        }
    }


    @Override
    public Iterator<T> iterator() {
        return Arrays.stream(values).iterator();
    }

    public T first() {
        if (length == 0) throw new IllegalStateException("Array is empty.");
        return values[0];
    }
}
