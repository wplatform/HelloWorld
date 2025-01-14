package com.github.azeroth.game.entity;


public class UpdateField<T> implements IUpdateField<T> {
    private T value;
    private int blockBit;
    private int bit;

    public UpdateField(int blockBit, int bit) {
        setBlockBit(blockBit);
        setBit(bit);
        setValue(new T());
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
        setValue(value);
    }


//	public static implicit operator T(UpdateField<T> updateField)
//		{
//			return updateField.value;
//		}
}
