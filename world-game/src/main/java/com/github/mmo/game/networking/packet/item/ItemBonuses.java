package com.github.mmo.game.networking.packet.item;


import com.github.mmo.dbc.defines.ItemContext;
import com.github.mmo.game.networking.*;
import java.util.*;


public class ItemBonuses
{
	public ItemContext context = ItemContext.values()[0];
	public ArrayList<Integer> bonusListIDs = new ArrayList<>();

	public final void write(WorldPacket data)
	{
		data.writeInt8((byte)context.getValue());
		data.writeInt32(bonusListIDs.size());

		for (var bonusID : bonusListIDs)
		{
			data.writeInt32(bonusID);
		}
	}

	public final void read(WorldPacket data)
	{
		context = itemContext.forValue(data.readUInt8());
		var bonusListIdSize = data.readUInt();

		bonusListIDs = new ArrayList<>();

		for (var i = 0; i < bonusListIdSize; ++i)
		{
			var bonusId = data.readUInt();
			bonusListIDs.add(bonusId);
		}
	}

	@Override
	public int hashCode()
	{
		return context.hashCode() ^ bonusListIDs.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof ItemBonuses)
		{
			return ItemBonuses.opEquals((ItemBonuses)obj, this);
		}

		return false;
	}

	public static boolean opEquals(ItemBonuses left, ItemBonuses right)
	{
		if (left == right)
		{
			return true;
		}

		if (left == null || right == null)
		{
			return false;
		}

		if (left.context != right.context)
		{
			return false;
		}

		if (left.bonusListIDs.size() != right.bonusListIDs.size())
		{
			return false;
		}

		return left.bonusListIDs.equals(right.bonusListIDs);
	}

	public static boolean opNotEquals(ItemBonuses left, ItemBonuses right)
	{
		return !(ItemBonuses.opEquals(left, right));
	}
}
