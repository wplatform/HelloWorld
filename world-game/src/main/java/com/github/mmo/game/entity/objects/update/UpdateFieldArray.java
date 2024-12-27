package com.github.mmo.game.entity;

import java.util.*;


// C# TO JAVA CONVERTER TASK: The C# 'new()' constraint has no equivalent in Java:
// C# TO JAVA CONVERTER TASK: The interface type was changed to the closest equivalent Java type, but the methods implemented will need adjustment:
public class UpdateFieldArray<T> implements Iterable<T>
{
	private T[] values;
	public final T[] getValues()
	{
		return values;
	}
	public final void setValues(T[] value)
	{
		values = value;
	}
	private int firstElementBit;
	public final int getFirstElementBit()
	{
		return firstElementBit;
	}
	public final void setFirstElementBit(int value)
	{
		firstElementBit = value;
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

	public final T get(int index)
	{
		return getValues()[index];
	}
	public final void set(int index, T value)
	{
		getValues()[index] = value;
	}

	public UpdateFieldArray(int size, int bit, int firstElementBit)
	{
		setValues((T[])new Object[size]);

		for (var i = 0; i < size; ++i)
		{
			getValues()[i] = new T();
		}

		setBit(bit);
		setFirstElementBit(firstElementBit);
	}

	public final Iterator<T> iterator()
	{
		for (var obj : getValues())
		{
// C# TO JAVA CONVERTER TASK: Java does not have an equivalent to the C# 'yield' keyword:
			yield return obj;
		}
	}

	public final Iterator getEnumerator()
	{
		return getEnumerator();
	}

	public final int getSize()
	{
		return getValues().length;
	}
}
