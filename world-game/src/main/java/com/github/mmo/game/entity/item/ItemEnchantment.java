package com.github.mmo.game.entity.item;

import com.github.mmo.game.entity.BaseUpdateData;
import com.github.mmo.game.entity.UpdateField;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.*;

public class ItemEnchantment extends BaseUpdateData<item>
{
	public UpdateField<Integer> ID = new UpdateField<Integer>(0, 1);
	public UpdateField<Integer> duration = new UpdateField<Integer>(0, 2);
	public UpdateField<SHORT> charges = new UpdateField<SHORT>(0, 3);
	public UpdateField<SHORT> inactive = new UpdateField<SHORT>(0, 4);

	public ItemEnchantment()
	{
		super(5);
	}

	public final void writeCreate(WorldPacket data, Item owner, Player receiver)
	{
		data.writeInt32(ID);
		data.writeInt32(duration);
		data.writeInt16(charges);
		data.writeInt16(inactive);
	}

	public final void writeUpdate(WorldPacket data, boolean ignoreChangesMask, Item owner, Player receiver)
	{
		var changesMask = getChangesMask();

		if (ignoreChangesMask)
		{
			changesMask.setAll();
		}

		data.writeBits(changesMask.getBlock(0), 5);

		data.flushBits();

		if (changesMask.get(0))
		{
			if (changesMask.get(1))
			{
				data.writeInt32(ID);
			}

			if (changesMask.get(2))
			{
				data.writeInt32(duration);
			}

			if (changesMask.get(3))
			{
				data.writeInt16(charges);
			}

			if (changesMask.get(4))
			{
				data.writeInt16(inactive);
			}
		}
	}

	@Override
	public void clearChangesMask()
	{
		clearChangesMask(ID);
		clearChangesMask(duration);
		clearChangesMask(charges);
		clearChangesMask(inactive);
		getChangesMask().resetAll();
	}
}
