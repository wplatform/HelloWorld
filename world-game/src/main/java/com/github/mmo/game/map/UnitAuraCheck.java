package com.github.mmo.game.map;

import com.github.mmo.game.entity.object.WorldObject;

public class UnitAuraCheck<T extends WorldObject> implements ICheck<T>
{
	private final boolean present;
	private final int spellId;
	private final ObjectGuid casterGUID;


	public UnitAuraCheck(boolean present, int spellId)
	{
		this(present, spellId, null);
	}

	public UnitAuraCheck(boolean present, int spellId, ObjectGuid casterGUID)
	{
		present = present;
		spellId = spellId;
        casterGUID = casterGUID;
	}

	public final boolean invoke(T obj)
	{
        return obj.toUnit() && obj.toUnit().hasAura(spellId, casterGUID) == present;
	}

// C# TO JAVA CONVERTER TASK: The following operator overload is not converted by C# to Java Converter:
//	public static implicit operator Predicate<T>(UnitAuraCheck<T> unit)
//		{
//			return unit.Invoke;
//		}
}
