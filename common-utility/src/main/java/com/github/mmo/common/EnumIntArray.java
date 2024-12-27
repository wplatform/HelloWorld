package com.github.mmo.common;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class EnumIntArray<T extends Enum<T>> {
    private final int[] m_values;
    private int m_flags;

    public static <T extends Enum<T>> EnumIntArray<T> of(Class<T> enumClass) {
        return new EnumIntArray<>(new int[enumClass.getEnumConstants().length]);
    }

    public final int getFlags() {
        return m_flags;
    }

    public final boolean hasFlag(T element) {
        return (m_flags & 1 << element.ordinal()) != 0;
    }

    public final void addFlag(T element) {
        m_flags |= (1 << element.ordinal());
    }

    public final void delFlag(T flag) {
        m_flags &= ~(1 << flag.ordinal());
    }

    public final int getValue(T flag) {
        return m_values[flag.ordinal()];
    }

    public final void setValue(T flag, int value) {
        m_values[flag.ordinal()] = value;
    }

    public final void addValue(T flag, int value) {
        m_values[flag.ordinal()] += value;
    }
}

