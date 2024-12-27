package com.github.mmo.game.entity;
// C# TO JAVA CONVERTER TASK: The C# 'new()' constraint has no equivalent in Java:
public class UpdateField<T> implements IUpdateField<T>
{
	private T value;
	public final T getValue()
	{
		return value;
	}
	public final void setValue(T value)
	{
		value = value;
	}
	private int blockBit;
	public final int getBlockBit()
	{
		return blockBit;
	}
	public final void setBlockBit(int value)
	{
		blockBit = value;
	}
	private int bit;
	public final int getBit()
	{
		return bit;
	}
	public final void setBit(int value)
	{
		bit = value;
	}

	public UpdateField(int blockBit, int bit)
	{
		setBlockBit(blockBit);
		setBit(bit);
		setValue(new T());
	}

	public final void setValue(T value)
	{
		setValue(value);
	}

	public final T getValue()
	{
		return getValue();
	}

// C# TO JAVA CONVERTER TASK: The following operator overload is not converted by C# to Java Converter:
//	public static implicit operator T(UpdateField<T> updateField)
//		{
//			return updateField.value;
//		}
}
