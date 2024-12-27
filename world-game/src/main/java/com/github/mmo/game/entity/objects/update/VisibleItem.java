package com.github.mmo.game.entity;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.networking.*;

public class VisibleItem extends BaseUpdateData<unit>
{
	public UpdateField<Integer> itemID = new UpdateField<Integer>(0, 1);
	public UpdateField<Integer> secondaryItemModifiedAppearanceID = new UpdateField<Integer>(0, 2);
	public UpdateField<SHORT> itemAppearanceModID = new UpdateField<SHORT>(0, 3);
	public UpdateField<SHORT> itemVisual = new UpdateField<SHORT>(0, 4);

	public VisibleItem()
	{
		super(5);
	}

	public final void writeCreate(WorldPacket data, Unit owner, Player receiver)
	{
		data.writeInt32(itemID);
		data.writeInt32(secondaryItemModifiedAppearanceID);
		data.writeInt16(itemAppearanceModID);
		data.writeInt16(itemVisual);
	}

	public final void writeUpdate(WorldPacket data, boolean ignoreChangesMask, Unit owner, Player receiver)
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
				data.writeInt32(itemID);
			}

			if (changesMask.get(2))
			{
				data.writeInt32(secondaryItemModifiedAppearanceID);
			}

			if (changesMask.get(3))
			{
				data.writeInt16(itemAppearanceModID);
			}

			if (changesMask.get(4))
			{
				data.writeInt16(itemVisual);
			}
		}
	}

	@Override
	public void clearChangesMask()
	{
		clearChangesMask(itemID);
		clearChangesMask(secondaryItemModifiedAppearanceID);
		clearChangesMask(itemAppearanceModID);
		clearChangesMask(itemVisual);
		getChangesMask().resetAll();
	}
}
