package com.github.mmo.game.entity;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.*;

public class CraftingOrderItem extends BaseUpdateData<Player>
{
	public UpdateField<Long> field_0 = new UpdateField<Long>(-1, 0);
	public UpdateField<ObjectGuid> itemGUID = new UpdateField<ObjectGuid>(-1, 1);
	public UpdateField<ObjectGuid> ownerGUID = new UpdateField<ObjectGuid>(-1, 2);
	public UpdateField<Integer> itemID = new UpdateField<Integer>(-1, 3);
	public UpdateField<Integer> quantity = new UpdateField<Integer>(-1, 4);
	public UpdateField<Integer> reagentQuality = new UpdateField<Integer>(-1, 5);
	public OptionalUpdateField<Byte> dataSlotIndex = new OptionalUpdateField<Byte>(-1, 6);

	public CraftingOrderItem()
	{
		super(7);
	}

	public final void writeCreate(WorldPacket data, Player owner, Player receiver)
	{
		data.writeInt64(field_0);
		data.writeGuid(itemGUID);
		data.writeGuid(ownerGUID);
		data.writeInt32(itemID);
		data.writeInt32(quantity);
		data.writeInt32(reagentQuality);
		data.writeBits(dataSlotIndex.hasValue(), 1);

		if (dataSlotIndex.hasValue())
		{
			data.writeInt8(dataSlotIndex);
		}
	}

	public final void writeUpdate(WorldPacket data, boolean ignoreChangesMask, Player owner, Player receiver)
	{
		var changesMask = getChangesMask();

		if (ignoreChangesMask)
		{
			changesMask.setAll();
		}

		data.writeBits(changesMask.getBlock(0), 7);

		data.flushBits();

		if (changesMask.get(0))
		{
			data.writeInt64(field_0);
		}

		if (changesMask.get(1))
		{
			data.writeGuid(itemGUID);
		}

		if (changesMask.get(2))
		{
			data.writeGuid(ownerGUID);
		}

		if (changesMask.get(3))
		{
			data.writeInt32(itemID);
		}

		if (changesMask.get(4))
		{
			data.writeInt32(quantity);
		}

		if (changesMask.get(5))
		{
			data.writeInt32(reagentQuality);
		}

		data.writeBits(dataSlotIndex.hasValue(), 1);

		if (changesMask.get(6))
		{
			if (dataSlotIndex.hasValue())
			{
				data.writeInt8(dataSlotIndex);
			}
		}
	}

	@Override
	public void clearChangesMask()
	{
		clearChangesMask(field_0);
		clearChangesMask(itemGUID);
		clearChangesMask(ownerGUID);
		clearChangesMask(itemID);
		clearChangesMask(quantity);
		clearChangesMask(reagentQuality);
		clearChangesMask(dataSlotIndex);
		getChangesMask().resetAll();
	}
}
