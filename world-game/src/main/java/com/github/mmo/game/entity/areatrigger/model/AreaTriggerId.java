package com.github.mmo.game.entity.areatrigger.model;
public final class AreaTriggerId
{
	public int id;
	public boolean isServerSide;

	public areaTriggerId()
	{
	}

	public areaTriggerId(int id, boolean isServerSide)
	{
		id = id;
		isServerSide = isServerSide;
	}

	@Override
	public int hashCode()
	{
		return (new integer(id)).hashCode() ^ (new Boolean(isServerSide)).hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		return AreaTriggerId.opEquals(this, (AreaTriggerId)obj);
	}

	public static boolean opEquals(AreaTriggerId left, AreaTriggerId right)
	{
		return left.id == right.id && left.isServerSide == right.isServerSide;
	}

	public static boolean opNotEquals(AreaTriggerId left, AreaTriggerId right)
	{
		return !(AreaTriggerId.opEquals(left, right));
	}

	public AreaTriggerId clone()
	{
		AreaTriggerId varCopy = new areaTriggerId();

		varCopy.id = this.id;
		varCopy.isServerSide = this.isServerSide;

		return varCopy;
	}
}
