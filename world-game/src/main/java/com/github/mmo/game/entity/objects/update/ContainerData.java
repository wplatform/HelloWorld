package com.github.mmo.game.entity;


import com.github.mmo.game.entity.item.bag;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.*;

public class ContainerData extends BaseUpdateData<bag>
{
	public UpdateField<Integer> numSlots = new UpdateField<Integer>(0, 1);
	public UpdateFieldArray<ObjectGuid> slots = new UpdateFieldArray<ObjectGuid>(36, 2, 3);

	public containerData()
	{
		super(0, TypeId.Container, 39);
	}

	public final void writeCreate(WorldPacket data, UpdateFieldFlag fieldVisibilityFlags, Bag owner, Player receiver)
	{
		for (var i = 0; i < 36; ++i)
		{
			data.writeGuid(slots.get(i));
		}

		data.writeInt32(numSlots);
	}

	public final void writeUpdate(WorldPacket data, UpdateFieldFlag fieldVisibilityFlags, Bag owner, Player receiver)
	{
		writeUpdate(data, getChangesMask(), false, owner, receiver);
	}

	public final void writeUpdate(WorldPacket data, UpdateMask changesMask, boolean ignoreNestedChangesMask, Bag owner, Player receiver)
	{
		data.writeBits(getChangesMask().getBlocksMask(0), 2);

		for (int i = 0; i < 2; ++i)
		{
			if (getChangesMask().getBlock(i) != 0)
			{
				data.writeBits(getChangesMask().getBlock(i), 32);
			}
		}

		data.flushBits();

		if (getChangesMask().get(0))
		{
			if (getChangesMask().get(1))
			{
				data.writeInt32(numSlots);
			}
		}

		if (getChangesMask().get(2))
		{
			for (var i = 0; i < 36; ++i)
			{
				if (getChangesMask().get(3 + i))
				{
					data.writeGuid(slots.get(i));
				}
			}
		}
	}

	@Override
	public void clearChangesMask()
	{
		clearChangesMask(numSlots);
		clearChangesMask(slots);
		getChangesMask().resetAll();
	}
}
