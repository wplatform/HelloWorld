package com.github.mmo.game.entity;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.*;

public class ArenaCooldown extends BaseUpdateData<Player>
{
	public UpdateField<Integer> spellID = new UpdateField<Integer>(0, 1);
	public UpdateField<Integer> charges = new UpdateField<Integer>(0, 2);
	public UpdateField<Integer> flags = new UpdateField<Integer>(0, 3);
	public UpdateField<Integer> startTime = new UpdateField<Integer>(0, 4);
	public UpdateField<Integer> endTime = new UpdateField<Integer>(0, 5);
	public UpdateField<Integer> nextChargeTime = new UpdateField<Integer>(0, 6);
	public UpdateField<Byte> maxCharges = new UpdateField<Byte>(0, 7);

	public ArenaCooldown()
	{
		super(8);
	}

	public final void writeCreate(WorldPacket data, Player owner, Player receiver)
	{
        data.writeInt32(spellID);
        data.writeInt32(charges);
        data.writeInt32(flags);
        data.writeInt32(startTime);
        data.writeInt32(endTime);
        data.writeInt32(nextChargeTime);
		data.writeInt8(maxCharges);
	}

	public final void writeUpdate(WorldPacket data, boolean ignoreChangesMask, Player owner, Player receiver)
	{
		var changesMask = getChangesMask();

		if (ignoreChangesMask)
		{
			changesMask.setAll();
		}

        data.writeBits(changesMask.getBlock(0), 8);

        data.flushBits();

		if (changesMask.get(0))
		{
			if (changesMask.get(1))
			{
                data.writeInt32(spellID);
			}

			if (changesMask.get(2))
			{
                data.writeInt32(charges);
			}

			if (changesMask.get(3))
			{
                data.writeInt32(flags);
			}

			if (changesMask.get(4))
			{
                data.writeInt32(startTime);
			}

			if (changesMask.get(5))
			{
                data.writeInt32(endTime);
			}

			if (changesMask.get(6))
			{
                data.writeInt32(nextChargeTime);
			}

			if (changesMask.get(7))
			{
				data.writeInt8(maxCharges);
			}
		}
	}

	@Override
	public void clearChangesMask()
	{
		clearChangesMask(spellID);
		clearChangesMask(charges);
		clearChangesMask(flags);
		clearChangesMask(startTime);
		clearChangesMask(endTime);
		clearChangesMask(nextChargeTime);
		clearChangesMask(maxCharges);
		getChangesMask().resetAll();
	}
}
