package com.github.mmo.game.entity;

// C# TO JAVA CONVERTER TASK: The C# 'new()' constraint has no equivalent in Java:
public class OptionalUpdateField<T> implements IUpdateField<T> {
    private boolean hasValue;
    private T value;
    private int blockBit;
    private int bit;

    public OptionalUpdateField(int blockBit, int bit) {
        setBlockBit(blockBit);
        setBit(bit);
    }

    public final T getValue() {
        return value;
    }

    public final int getBlockBit() {
        return blockBit;
    }

    public final void setBlockBit(int value) {
        blockBit = value;
    }

    public final int getBit() {
        return bit;
    }

    public final void setBit(int value) {
        bit = value;
    }

    public final T getValue() {
        return getValue();
    }

    public final void setValue(T value) {
        value = value;
    }

    public final void setValue(T value) {
        hasValue = true;
        setValue(value);
    }

// C# TO JAVA CONVERTER TASK: The following operator overload is not converted by C# to Java Converter:
//	public static implicit operator T(OptionalUpdateField<T> updateField)
//		{
//			return updateField.value;
//		}

    public final boolean hasValue() {
        return hasValue;
    }
}
