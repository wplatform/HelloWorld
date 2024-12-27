package com.github.mmo.game.entity;
// C# TO JAVA CONVERTER TASK: The C# 'new()' constraint has no equivalent in Java:
public class OptionalUpdateField<T> implements IUpdateField<T>
{
	private boolean hasValue;
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

	public OptionalUpdateField(int blockBit, int bit)
	{
		setBlockBit(blockBit);
		setBit(bit);
	}

	public final void setValue(T value)
	{
		hasValue = true;
		setValue(value);
	}

	public final T getValue()
	{
		return getValue();
	}

// C# TO JAVA CONVERTER TASK: The following operator overload is not converted by C# to Java Converter:
//	public static implicit operator T(OptionalUpdateField<T> updateField)
//		{
//			return updateField.value;
//		}

	public final boolean hasValue()
	{
		return hasValue;
	}
}
